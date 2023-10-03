package com.example.andreysshop.service;

import com.example.andreysshop.domain.serviceModel.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userRegisterServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    //  void logOut();
}
