package com.rishi.gholdengo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("ACCOUNT")
public class Account {
    @Id
    private Integer id;

    private BigDecimal balance;

    private Integer customerId;

    public Account() {
    }

    public Account(Integer id, BigDecimal balance, Integer customerId) {
        this.id = id;
        this.balance = balance;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
