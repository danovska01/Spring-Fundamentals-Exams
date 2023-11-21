package project.spotifyplaylist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.spotifyplaylist.model.entity.Song;
import project.spotifyplaylist.model.entity.enums.StyleNameEnum;

import java.util.Set;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {

    Set<Song> findAllByStyle_StyleName(StyleNameEnum s);


}
