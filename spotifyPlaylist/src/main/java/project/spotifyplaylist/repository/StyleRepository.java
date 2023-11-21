package project.spotifyplaylist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.spotifyplaylist.model.entity.Style;
import project.spotifyplaylist.model.entity.enums.StyleNameEnum;



@Repository
public interface StyleRepository extends JpaRepository<Style, String> {
    Style findByStyleName(StyleNameEnum style);



}
