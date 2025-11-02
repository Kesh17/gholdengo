package com.rishi.gholdengo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

//@Table("TRANSACTIONS")
public class Transactions {
    @Id
    private Integer id;

    private Integer accountId;

    private Integer fromAccountId;

    private BigDecimal amount;

    @Column("TRANSACTION_TYPE")
    private TransactionType transactionType;

    private String description;

    public Transactions() {
    }

    public Transactions(Integer id, Integer accountId, Integer fromAccountId, BigDecimal amount, TransactionType transactionType, String description) {
        this.id = id;
        this.accountId = accountId;
        this.fromAccountId = fromAccountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public TransactionType getTransactionsType() {
        return transactionType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public void setTransactionsType(TransactionType transactionsType) {
        this.transactionType = transactionsType;
    }
}
