package com.danovska01.shoppinglist.service;

import com.danovska01.shoppinglist.model.service.UserServiceModel;



public interface UserService  {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
