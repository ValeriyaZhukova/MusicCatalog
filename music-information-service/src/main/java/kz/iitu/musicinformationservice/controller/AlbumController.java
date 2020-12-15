package kz.iitu.musicinformationservice.controller;

import kz.iitu.musicinformationservice.model.Album;
import kz.iitu.musicinformationservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping("")
    public List<Album> getAllAlbums()
    {
        return albumService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public Album getAlbumByID(@PathVariable("id") Long id)
    {
        return albumService.getAlbumByID(id);
    }
}
