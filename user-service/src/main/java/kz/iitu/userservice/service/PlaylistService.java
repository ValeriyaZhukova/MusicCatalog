package kz.iitu.userservice.service;

import kz.iitu.userservice.model.Playlist;
import kz.iitu.userservice.model.Song;
import kz.iitu.userservice.model.User;
import kz.iitu.userservice.repository.PlaylistRepository;
import kz.iitu.userservice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    SongRepository songRepository;

    public Playlist getPlaylistByID(Long id)
    {
        return playlistRepository.findById(id).get();
    }

    public void createPlaylist(Playlist playlist)
    {
        playlistRepository.saveAndFlush(playlist);
    }

    public void addSongToPlaylist(Song song, Playlist playlist)
    {
        playlist.getSongList().add(song);
        song.getPlaylists().add(playlist);

        playlistRepository.saveAndFlush(playlist);
    }
}
