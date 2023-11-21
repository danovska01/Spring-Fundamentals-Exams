package project.spotifyplaylist.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import project.spotifyplaylist.model.entity.Song;
import project.spotifyplaylist.model.entity.User;
import project.spotifyplaylist.model.entity.enums.StyleNameEnum;
import project.spotifyplaylist.model.service.SongServiceModel;
import project.spotifyplaylist.repository.SongRepository;
import project.spotifyplaylist.repository.StyleRepository;
import project.spotifyplaylist.repository.UserRepository;

import java.util.Set;


@Service
public class SongServiceImpl implements SongService{
    private final SongRepository songRepository;
    private final ModelMapper modelMapper;
    private final StyleRepository styleRepository;
    private final UserRepository userRepository;


    public SongServiceImpl(SongRepository songRepository, ModelMapper modelMapper, StyleRepository styleRepository, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.modelMapper = modelMapper;
        this.styleRepository = styleRepository;
        this.userRepository = userRepository;

    }


    @Override
    public void add(SongServiceModel songServiceModel) {
        Song song = modelMapper.map(songServiceModel, Song.class);
        song.setStyle(styleRepository.findByStyleName(songServiceModel.getStyle()));
        songRepository.save(song);
    }

    @Override
    public Set<Song> getSongsByStyle(StyleNameEnum styleNameEnum) {
        return songRepository.findAllByStyle_StyleName(styleNameEnum);
    }

    @Override
    public void addSong(String songId, String userId) {
        Song song = songRepository.findById(songId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if(song != null && user != null){
            user.addSong(song);
            userRepository.save(user);
    }
    }
}
