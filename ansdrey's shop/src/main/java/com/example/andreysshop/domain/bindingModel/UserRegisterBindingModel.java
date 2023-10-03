package com.example.andreysshop.domain.bindingModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class UserRegisterBindingModel {

    private Long id;
    @Size(min = 2, message = "Username length must be more than two characters")
    private String username;
    @Email(message = "Email must contain '@'")
    private String email;
    @Positive(message = "Must be a positive number")
    private BigDecimal budget = BigDecimal.valueOf(0);
    @Size(min = 2, message = "Password length must be more than two characters!!!")
    private String password;
    @Size(min = 2)
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public UserRegisterBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public UserRegisterBindingModel setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
