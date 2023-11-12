package com.danovska01.musicdb.service;

import com.danovska01.musicdb.model.entity.Album;
import com.danovska01.musicdb.model.entity.Artist;
import com.danovska01.musicdb.model.entity.User;
import com.danovska01.musicdb.model.service.AlbumServiceModel;
import com.danovska01.musicdb.repository.AlbumRepository;
import com.danovska01.musicdb.repository.ArtistRepository;
import com.danovska01.musicdb.repository.UserRepository;
import com.danovska01.musicdb.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService{
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public AlbumServiceImpl(AlbumRepository albumRepository,
                            ModelMapper modelMapper,
                            ArtistRepository artistRepository,
                            UserRepository userRepository,
                            CurrentUser currentUser) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistRepository = artistRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    @Override
    public void add(AlbumServiceModel albumServiceModel) {
        Album album = modelMapper.map(albumServiceModel, Album.class);

        System.out.println(albumServiceModel.getArtist()  + "   SERVICE");
        Artist artist = artistRepository.findByName(albumServiceModel.getArtist());
        album.setArtist(artist);

        User creator = userRepository.findById(currentUser.getId()).orElse(null);
        album.setAddedFrom(creator);

        albumRepository.save(album);
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        albumRepository.deleteById(id);
    }

    @Override
    public BigDecimal getNumberOfAllCopies() {
        return albumRepository.findAllCopies();
    }
}
