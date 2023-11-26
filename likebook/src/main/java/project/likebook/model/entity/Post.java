package project.likebook.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Table(name = "posts")
@Entity
public class Post extends BaseEntity {


    @Column(nullable = false)
    private String content;



    //The creator of the post; one user may have many posts.
    @ManyToOne
    private User user;



    //One post has one mood and one mood can have many posts.
    @ManyToOne
    @JoinColumn(nullable = false)
    private Mood mood;



    //The user likes contains users. One user may like many posts and one post can be liked by many users.
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> userLikes;




    public Post() {
        this.userLikes = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public List<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<User> userLikes) {
        this.userLikes = userLikes;
    }

    public void addUser(User user) {
        this.userLikes.add(user);
    }

    public boolean isLikedByUserByUserId(String userId) {
        return userLikes.stream().anyMatch(u -> u.getId().equals(userId));
    }
}
