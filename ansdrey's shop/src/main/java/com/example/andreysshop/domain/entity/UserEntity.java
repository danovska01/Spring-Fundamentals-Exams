package com.example.andreysshop.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    @Column
    private BigDecimal budget;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public UserEntity setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }
}
//•	Has a Username (unique)
//o	Username must be unique
//o	Username length must be more than two characters

//•	Has a Password
//o	Password length must be more than two characters

//•	Has an Email
//o	Email must contain '@'

//•	Has a Budget
//o	Must be a positive number