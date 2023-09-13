package webapp.gira.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import webapp.gira.models.entities.User;
import webapp.gira.models.service.UserServiceModel;
import webapp.gira.repositories.UserRepository;
import webapp.gira.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private UserServiceModel userServiceModel;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findByEmailAndPassword(String email, String password) {

        return
                userRepository.findByEmailAndPassword(email, password)
                        .map(user -> modelMapper.map(user, UserServiceModel.class))
                        .orElse(null);
    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserServiceModel getUserServiceModel() {
        return userServiceModel;
    }

    @Override
    public void setUserServiceModel(UserServiceModel userServiceModel) {
        this.userServiceModel = userServiceModel;
    }
}
