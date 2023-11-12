package com.danovska01.musicdb.repository;


import com.danovska01.musicdb.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {

    @Query("SELECT SUM(a.copies) FROM Album a")
    BigDecimal findAllCopies();
}
