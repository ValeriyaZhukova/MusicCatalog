package kz.iitu.musiccatalog.controller;

import kz.iitu.musiccatalog.model.Album;
import kz.iitu.musiccatalog.model.Song;
import kz.iitu.musiccatalog.model.SongList;
import kz.iitu.musiccatalog.model.User;
import kz.iitu.musiccatalog.service.MusicInformationService;
import kz.iitu.musiccatalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class MusicCatalogController {

    @Autowired
    private MusicInformationService musicInformationService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String getMessage()
    {
        return "Welcome to music library";
    }

    @GetMapping("/songs/{songId}")
    public ResponseEntity<Song> getSongById(@PathVariable Long songId)
    {
        Song song = musicInformationService.getSongByID(songId);
        return ResponseEntity.ok(song);
    }

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getSongs()
    {
        List<Song> songs = musicInformationService.getSongs();
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/songs/album/{albumID}")
    public ResponseEntity<List<Song>> getSongsByAlbumID(@PathVariable Long albumID)
    {
        List<Song> songs = musicInformationService.getSongsByAlbumID(albumID);
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/albums/{albumID}")
    public ResponseEntity<Album> getAlbumByID(@PathVariable Long albumID)
    {
        Album album = musicInformationService.getAlbumByID(albumID);
        return ResponseEntity.ok(album);
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAlbums()
    {
        List<Album> albums = musicInformationService.getAlbums();
        return ResponseEntity.ok(albums);
    }




   /* @GetMapping("/users/{userID}")
    public User getUserById(@PathVariable Long userID)
    {
        User user = userService.getUserByID(userID);
        return user;
    }*/

     /*  @PostMapping("/users/login")
    public void login(@RequestBody User user)
    {

    }*/

}
