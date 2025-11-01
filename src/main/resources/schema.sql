create table if not exists customer (
    id bigint auto_increment primary key,
    name varchar(255) not null,
    password varchar(255) not null
);