package dictionary.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {
    @NotBlank(message = "The field cannot be empty string")
    @Size(min = 3, max = 20, message = "Allowed size is 3 - 20 symbols")
    private String username;
    @NotBlank(message = "The field cannot be empty string")
    @Size(min = 3, max = 20, message = "Allowed size is 3 - 20 symbols")
    private String password;
    @NotBlank(message = "The field cannot be empty string")
    @Size(min = 3, max = 20, message = "Allowed size is 3 - 20 symbols")
    private String confirmPassword;
    @NotBlank(message = "The field cannot be empty string")
    @Email(message = "Enter valid email, please")
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

