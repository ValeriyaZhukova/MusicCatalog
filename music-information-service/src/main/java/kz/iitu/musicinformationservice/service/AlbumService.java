package kz.iitu.musicinformationservice.service;

import kz.iitu.musicinformationservice.model.Album;
import kz.iitu.musicinformationservice.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album getAlbumByID(Long id)
    {
        return albumRepository.findById(id).get();
    }

    public List<Album> getAllAlbums()
    {
        return albumRepository.findAll();
    }
}
