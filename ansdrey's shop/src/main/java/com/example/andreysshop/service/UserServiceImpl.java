package com.example.andreysshop.service;

import com.example.andreysshop.domain.entity.UserEntity;
import com.example.andreysshop.domain.serviceModel.UserServiceModel;
import com.example.andreysshop.repository.UserRepository;
import com.example.andreysshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

        userRepository.save(modelMapper.map(userServiceModel, UserEntity.class));

    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id).setUsername(username);
    }

    // @Override
    //  public void logOut() {
    //     currentUser.setId(null).setUsername(null);
    //  }
}
