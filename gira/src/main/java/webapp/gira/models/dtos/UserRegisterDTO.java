package webapp.gira.models.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterDTO {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public UserRegisterDTO() {
    }

    @NotBlank(message = "Username blank cannot be empty")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters")
    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank(message = "Email blank cannot be empty")
    @Email(message = "Email address must be valid")
    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Password blank cannot be empty")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank(message = "Password blank cannot be empty")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
