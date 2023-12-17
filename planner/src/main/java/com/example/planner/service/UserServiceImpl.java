package com.example.planner.service;

import com.example.planner.model.entity.Task;
import com.example.planner.model.entity.User;
import com.example.planner.model.service.UserServiceModel;
import com.example.planner.repository.UserRepository;
import com.example.planner.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
      return  userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class)).orElse(null);
    }

    @Override
    public void loginUser(String id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }


    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    @Override
    public User findById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Optional<UserServiceModel> findUserById(String id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserServiceModel.class));
    }

    @Override
    public Set<Task> getAssignedTasksFromCurrentUser(String id) {
        User user = userRepository.findById(id).orElse(null);
        return user.getAssignedTasks();
    }



    @Override
    public Set<User> getAllOtherUsers() {
        return userRepository.findAllByIdIsNot(currentUser.getId());
    }




}
