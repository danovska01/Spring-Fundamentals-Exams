package com.danovska01.musicdb.service;

import com.danovska01.musicdb.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(String id, String username);

    void logout();
}
