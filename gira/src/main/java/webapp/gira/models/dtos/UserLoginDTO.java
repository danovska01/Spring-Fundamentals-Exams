package webapp.gira.models.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserLoginDTO {

    private String email;
    private String password;

    public UserLoginDTO() {
    }

    @NotEmpty(message = "Email blank cannot be empty")
    public String getEmail() {
        return email;
    }

    public UserLoginDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotEmpty(message = "Password blank cannot be empty")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
