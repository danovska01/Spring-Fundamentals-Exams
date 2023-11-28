package project.hero.service;


import project.hero.model.entity.User;
import project.hero.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(String id, String username);

    void logout();

    User findById(String id);
}
