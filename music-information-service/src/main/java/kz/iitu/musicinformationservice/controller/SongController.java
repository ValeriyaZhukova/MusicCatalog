package kz.iitu.musicinformationservice.controller;

import kz.iitu.musicinformationservice.model.Song;
import kz.iitu.musicinformationservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("")
    public List<Song> getAllSongs()
    {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Song getSongByID(@PathVariable("id") Long id)
    {
        return songService.getSongByID(id);
    }

    @GetMapping("/find")
    public List<Song> findSongsByTitle(@RequestParam("title") String title)
    {
        return songService.getSongsByTitle(title);
    }

    @GetMapping("/findByAlbum")
    public List<Song> findSongsByAlbum(@RequestParam("album_name") String album_name)
    {
        return songService.getSongsByAlbum(album_name);
    }

    @GetMapping("/album/{albumID}")
    public List<Song> getSongsByAlbumID(@PathVariable("albumID") Long albumID)
    {
        return songService.getSongsByAlbumID(albumID);
    }

    @PostMapping("")
    public Song addSong(@RequestBody Song song)
    {
        songService.addSong(song);
        return song;
    }
}
