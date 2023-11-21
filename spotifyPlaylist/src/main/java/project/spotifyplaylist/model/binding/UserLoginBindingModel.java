package project.spotifyplaylist.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
    @NotBlank(message = "Username cannot be empty string")
    @Size(min = 3, max = 20, message = "Username length is allowed to be from 3 to 20 characters")
    private String username;
    @NotBlank(message = "Password cannot be empty string")
    @Size(min = 3, max = 20, message = "Password length is allowed to be from 3 to 20 characters")
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
