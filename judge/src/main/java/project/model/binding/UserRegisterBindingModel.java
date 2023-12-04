package project.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {
    @Size(min = 3, max = 10)
    @NotBlank
    private String username;
    @Size(min = 3)
    @NotBlank
    private String password;
    @Size(min = 3)
    @NotBlank
    private String confirmPassword;
    @Email
    @NotBlank
    private String email;


    public UserRegisterBindingModel() {
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
