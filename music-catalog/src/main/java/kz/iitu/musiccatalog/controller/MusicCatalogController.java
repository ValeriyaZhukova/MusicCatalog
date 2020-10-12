package kz.iitu.musiccatalog.controller;

import kz.iitu.musiccatalog.model.Song;
import kz.iitu.musiccatalog.model.User;
import kz.iitu.musiccatalog.service.MusicInformationService;
import kz.iitu.musiccatalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Song getSongById(@PathVariable Long songId)
    {
        Song song = musicInformationService.getSongByID(songId);
        return song;
    }


    @GetMapping("/songs")
    public ResponseEntity<?> getSongs()
    {
        List<Song> songs = musicInformationService.getSongs();
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/songs/album/{albumID}")
    public ResponseEntity<?> getSongsByAlbumID(@PathVariable Long albumID)
    {
        List<Song> songs = musicInformationService.getSongsByAlbumID(albumID);
        return ResponseEntity.ok(songs);
    }

  /*  @PostMapping("/users/login")
    public void login(@RequestBody User user)
    {

    }*/
/*
    @GetMapping("/user")
    public User getUserByUsername(String username)
    {
        User user = userService.getUser(username);
        return user;
    }*/


}