package com.danovska01.coffeeshop.service;

import com.danovska01.coffeeshop.model.entity.User;
import com.danovska01.coffeeshop.model.service.UserServiceModel;
import com.danovska01.coffeeshop.model.view.UserViewModel;

import java.util.List;


public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
