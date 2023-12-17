package com.example.planner.service;


import com.example.planner.model.entity.Task;
import com.example.planner.model.entity.User;
import com.example.planner.model.service.UserServiceModel;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(String id, String username);

    void logout();

    User findById(String userId);

    Optional<UserServiceModel> findUserById(String id);

    Set<Task> getAssignedTasksFromCurrentUser(String id);

    Set<User> getAllOtherUsers();
}
