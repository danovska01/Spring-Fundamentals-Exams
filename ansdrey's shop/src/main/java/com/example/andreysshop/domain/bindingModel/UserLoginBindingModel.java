package com.example.andreysshop.domain.bindingModel;

import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
    @Size(min = 2, message = "Username length must be more than two characters!!!!!!!!!!!!!!!!!")
    private String username;
    @Size(min = 2, message = "Password length must be more than two characters!!!")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
