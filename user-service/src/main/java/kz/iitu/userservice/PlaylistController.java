package kz.iitu.userservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    PlaylistRepository playlistRepository;

    @GetMapping("/{userId}")
    public MainPlaylist getUserPlaylist(@PathVariable("userId") Long id)
    {
        return playlistRepository.findMainPlaylistByUserId(id);
    }
}
