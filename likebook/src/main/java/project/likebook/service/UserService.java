package project.likebook.service;


import project.likebook.model.entity.User;
import project.likebook.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    User findById(String userId);
}
