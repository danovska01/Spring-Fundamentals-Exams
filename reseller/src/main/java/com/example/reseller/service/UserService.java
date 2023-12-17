package com.example.reseller.service;

import com.example.reseller.model.entity.User;
import com.example.reseller.model.service.UserServiceModel;

import java.util.List;


public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(String id, String username);

    void logout();

    User findById(String id);

    List<User> getAllOtherUsers();
}
