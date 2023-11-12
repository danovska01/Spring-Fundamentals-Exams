package com.danovska01.musicdb.repository;


import com.danovska01.musicdb.model.entity.Artist;
import com.danovska01.musicdb.model.entity.enums.ArtistNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {
    Artist findByName(ArtistNameEnum artist);
}
