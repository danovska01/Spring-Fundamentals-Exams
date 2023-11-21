package project.spotifyplaylist.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.spotifyplaylist.model.entity.Song;
import project.spotifyplaylist.model.entity.User;
import project.spotifyplaylist.model.service.UserServiceModel;
import project.spotifyplaylist.repository.UserRepository;
import project.spotifyplaylist.util.CurrentUser;

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


        // OPTIONAL, BECAUSE OF THE HOME TEMPLATE NEED TO HIDE ADD BTN WHEN A SONG IS ALREADY ADDED TO THE LIST
        User user = userRepository.findById(id).orElse(null);
        user.getPlaylist().forEach(e -> System.out.println(e.getPerformer() + "    AAAaa   " + e.getDuration()));
        currentUser.setPlayList(user.getPlaylist());
    }


    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
        currentUser.setPlayList(null);
    }

    @Override
    public Set<Song> findSongsOfUserByUserId(String id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            return user.getPlaylist();
        }
        return null;
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void removeSongs() {
        User user = userRepository.findById(currentUser.getId()).orElse(null);
        if(user != null){
            user.getPlaylist().clear();
            userRepository.save(user);
        }
    }

}
