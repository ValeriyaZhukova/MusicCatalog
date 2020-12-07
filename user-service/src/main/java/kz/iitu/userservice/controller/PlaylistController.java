package kz.iitu.userservice.controller;

import kz.iitu.userservice.model.Playlist;
import kz.iitu.userservice.repository.PlaylistRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    PlaylistRepository playlistRepository;

    @GetMapping("/{userId}")
    public List<Playlist> getUserPlaylist(@PathVariable("userId") Long id)
    {
        return playlistRepository.findByUserId(id);
    }

    /*@PostMapping("/addSong")
    public void addSongToPlaylist(@RequestParam(""))
*/
}
