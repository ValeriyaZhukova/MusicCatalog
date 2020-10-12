package kz.iitu.musiccatalog.service;

import kz.iitu.musiccatalog.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Component
public class MusicInformationService {

    @Autowired
    RestTemplate restTemplate;

    public Song getSongByID(Long songID)
    {
        Song song = restTemplate.getForObject("http://music-information-service/songs/"+songID, Song.class);
        return song;
    }

    public List<Song> getSongs()
    {
        ResponseEntity<List<Song>> response = restTemplate.exchange(
                "http://music-information-service/songs",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Song>>(){});

        List<Song> songs = response.getBody();
        return songs;
    }

    public List<Song> getSongsByAlbumID(Long album_id)
    {
        ResponseEntity<List<Song>> response = restTemplate.exchange(
                "http://music-information-service/songs/findByAlbumID/"+album_id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Song>>(){});

        List<Song> songs = response.getBody();
        return songs;
    }




}
