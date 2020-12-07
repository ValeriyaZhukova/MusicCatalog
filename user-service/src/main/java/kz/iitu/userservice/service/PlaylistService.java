package kz.iitu.userservice.service;

import kz.iitu.userservice.model.Playlist;
import kz.iitu.userservice.model.Song;
import kz.iitu.userservice.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    public void createPlaylist(Playlist playlist)
    {
        playlistRepository.saveAndFlush(playlist);
    }

    public void addSongToPlaylist(Song song, Playlist playlist)
    {
        playlist.getSongList().add(song);
    }
}
