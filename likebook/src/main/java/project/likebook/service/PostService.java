package project.likebook.service;


import project.likebook.model.entity.Post;
import project.likebook.model.service.PostServiceModel;

import java.util.List;

public interface PostService {
    void add(PostServiceModel postServiceModel);

    List<Post> findMyPosts(String id);

    void removePostById(String id);

    List<Post> findOtherPosts(String userId);

    void likePost(String id, String userId);
}
