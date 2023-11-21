package project.spotifyplaylist.service;

import project.spotifyplaylist.model.entity.Song;
import project.spotifyplaylist.model.entity.enums.StyleNameEnum;
import project.spotifyplaylist.model.service.SongServiceModel;

import java.util.Set;

public interface SongService {
    void add(SongServiceModel songServiceModel);

    Set<Song> getSongsByStyle(StyleNameEnum styleNameEnum);

    void addSong(String songId, String userId);


}
