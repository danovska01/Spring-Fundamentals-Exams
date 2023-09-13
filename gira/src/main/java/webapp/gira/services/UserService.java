package webapp.gira.services;

import webapp.gira.models.entities.User;
import webapp.gira.models.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByEmailAndPassword(String email, String password);

    User findById(Long id);

    UserServiceModel getUserServiceModel();

    void setUserServiceModel(UserServiceModel userServiceModel);
}
