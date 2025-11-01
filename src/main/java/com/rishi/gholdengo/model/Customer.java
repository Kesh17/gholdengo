package com.rishi.gholdengo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "CUSTOMER")
public class Customer {
    @Id
    private Integer id;

    private String password;

    private String name;

    public Customer(Integer id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public Customer() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
