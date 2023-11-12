package com.danovska01.musicdb.service;

import com.danovska01.musicdb.model.entity.Album;
import com.danovska01.musicdb.model.service.AlbumServiceModel;

import java.math.BigDecimal;
import java.util.List;


public interface AlbumService {
    void add(AlbumServiceModel map);

    List<Album> getAllAlbums();

    void deleteById(String id);

    BigDecimal getNumberOfAllCopies();
}
