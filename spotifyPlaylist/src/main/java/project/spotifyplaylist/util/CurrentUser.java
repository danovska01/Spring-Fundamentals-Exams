package project.spotifyplaylist.util;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import project.spotifyplaylist.model.entity.Song;

import java.util.Set;

@Component
@SessionScope
public class CurrentUser {
    private String id;
    private String username;
    private Set<Song> playList;



    public CurrentUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Song> getPlayList() {
        return playList;
    }

    public void setPlayList(Set<Song> playList) {
        this.playList = playList;
    }
}
