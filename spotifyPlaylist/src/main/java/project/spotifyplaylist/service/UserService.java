package project.spotifyplaylist.service;


import project.spotifyplaylist.model.entity.Song;
import project.spotifyplaylist.model.entity.User;
import project.spotifyplaylist.model.service.UserServiceModel;

import java.util.Set;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(String id, String username);

    void logout();

    Set<Song> findSongsOfUserByUserId(String id);

    User findUserById(String id);

    void removeSongs();
}
