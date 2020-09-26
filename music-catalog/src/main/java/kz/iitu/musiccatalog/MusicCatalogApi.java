package kz.iitu.musiccatalog;
import kz.iitu.musiccatalog.model.MainPlaylist;
import kz.iitu.musiccatalog.model.Song;
import kz.iitu.musiccatalog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import kz.iitu.musiccatalog.service.*;

@RestController
@RequestMapping("/api/catalog")
public class MusicCatalogApi {

    @Autowired
    private MusicInformationService musicInformationService;
    @Autowired
    private UserService userService;

    @GetMapping("/songId")
    public Song getSongById(@PathVariable Long songId)
    {
        Song song = musicInformationService.getSongById(songId);
        return song;
    }

    @GetMapping("/user")
    public User getUserByUsername(String username)
    {
        User user = userService.getUser(username);
        return user;
    }

    @GetMapping("/playlist/{userId}")
    public MainPlaylist getUserPlaylist(@PathVariable("userId") Long id)
    {
        MainPlaylist playlist = userService.getUserPlaylist(id);
        return playlist;
    }
}
