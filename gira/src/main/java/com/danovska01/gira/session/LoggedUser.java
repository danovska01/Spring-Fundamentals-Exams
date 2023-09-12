package com.danovska01.gira.session;

import com.danovska01.gira.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {
    private long id;

    private String email;

    public void login(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
    }

    public void logout() {
        this.id = 0;
        this.email = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return email;
    }

    public void setFullName(String fullName) {
        this.email = fullName;
    }
}
