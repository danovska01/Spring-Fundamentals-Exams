package project.likebook.service;


import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.likebook.model.entity.Post;
import project.likebook.model.entity.User;
import project.likebook.model.service.PostServiceModel;
import project.likebook.model.service.UserServiceModel;
import project.likebook.repository.PostRepository;
import project.likebook.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final MoodService moodService;

    private final HttpSession httpSession;

    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, MoodService moodService, HttpSession httpSession, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.moodService = moodService;
        this.httpSession = httpSession;
        this.userRepository = userRepository;
    }

    @Override
    public void add(PostServiceModel postServiceModel) {
        Post post = modelMapper.map(postServiceModel, Post.class);
        post.setMood(moodService.findByMoodName(postServiceModel.getMood()));

       UserServiceModel user = (UserServiceModel) httpSession.getAttribute("user");
       post.setUser(modelMapper.map(user, User.class));

       post.setUserLikes(new ArrayList<>());
        postRepository.save(post);
    }

    @Override
    public List<Post> findMyPosts(String id) {
        return postRepository.findMyPosts(id);
    }

    @Override
    public void removePostById(String id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findOtherPosts(String userId) {
        return postRepository.findOtherPosts(userId);
    }

    @Override
    public void likePost(String postId, String userId) {
        Post post = postRepository.findById(postId).orElse(null);

        User user = userRepository.findById(userId).orElse(null);
        if(post != null){
            post.getUserLikes().add(user);
            postRepository.save(post);
        }
    }


}
