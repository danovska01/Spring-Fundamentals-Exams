package project.spotifyplaylist.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {
    @Size(min = 3, message = "hmm... It looks like the username is too short")
    @Size(max=20, message = "Oh! Username is too LONG, friend! Shorten it!")
    @NotBlank
    private String username;
    @NotBlank
    @Email
    private String email;
    @Size(min = 3, max = 20)
    @NotBlank
    private String password;
    @Size(min = 3, max = 20)
    @NotBlank
    private String confirmPassword;


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
