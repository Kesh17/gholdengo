create table if not exists customer (
    id bigint auto_increment primary key,
    name varchar(255) not null,
    password varchar(255) not null
);

create table if not exists account(
    id bigint auto_increment primary key,
    balance DECIMAL(12,2) DEFAULT 0.00,
    customer_id int not null,

    constraint fk_customer
    foreign key (customer_id) references customer(id)
);

create table if not exists transactions(
    id bigint auto_increment primary key,
    amount DECIMAL(12,2) DEFAULT 0.00,
    from_account_id int,
    account_id int not null,
    description varchar(255),
    transaction_type VARCHAR(20) NOT NULL CHECK (transaction_type IN ('DEPOSIT', 'WITHDRAW', 'TRANSFER')),

    constraint fk_account
    foreign key (account_id) references account(id)
);
