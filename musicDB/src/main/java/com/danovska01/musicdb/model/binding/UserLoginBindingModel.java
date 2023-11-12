package com.danovska01.musicdb.model.binding;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Size(min = 5, max = 20)
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}