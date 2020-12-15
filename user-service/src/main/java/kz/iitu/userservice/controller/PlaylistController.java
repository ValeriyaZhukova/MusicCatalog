package kz.iitu.userservice.controller;

import kz.iitu.userservice.model.Playlist;
import kz.iitu.userservice.model.Song;
import kz.iitu.userservice.repository.PlaylistRepository;
import kz.iitu.userservice.repository.SongRepository;
import kz.iitu.userservice.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    SongRepository songRepository;

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/{userId}")
    public List<Playlist> getUserPlaylist(@PathVariable("userId") Long id)
    {
        return playlistRepository.findByUserId(id);
    }

    @GetMapping("/get/{playlistId}")
    public Playlist getPlaylist(@PathVariable("playlistId") Long id)
    {
        return playlistService.getPlaylistByID(id);
    }

    @PostMapping("/addSong/")
    public List<Song> addSongToPlaylist(@RequestParam("song_id") Long songID)
    {
        Song song = songRepository.findById(songID).get();
        Playlist playlist = playlistRepository.findById(9L).get();

        playlistService.addSongToPlaylist(song, playlist);

        return playlistService.getPlaylistByID(9L).getSongList();
    }
}
