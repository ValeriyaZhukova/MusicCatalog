package kz.iitu.musicinformationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    SongRepository songRepository;

    @GetMapping("")
    public List<Song> getAllSongs()
    {
        return songRepository.findAll();
    }

    @GetMapping("/{id}")
    public Song getSongByID(@PathVariable("id") Long id)
    {
        return songRepository.getSongById(id);
    }

    public List<Song> findSongsByTitle(@RequestParam("title") String title)
    {
        return songRepository.findSongsByTitleContaining(title);
    }

    @PostMapping("")
    public Song addSong(@RequestBody Song song)
    {
        return songRepository.save(song);
    }
}
