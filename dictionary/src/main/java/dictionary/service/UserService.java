package dictionary.service;

import dictionary.model.service.UserServiceModel;


public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(String id, String username);

    void logout();


}
