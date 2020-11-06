package kz.iitu.musiccatalog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.musiccatalog.model.Album;
import kz.iitu.musiccatalog.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@EnableHystrix
@EnableHystrixDashboard
public class MusicInformationService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(
        fallbackMethod = "getSongsByIDFallback",
        threadPoolKey = "getSongsByID",
        threadPoolProperties = {
                @HystrixProperty(name = "coreSize", value = "20"),
                @HystrixProperty(name = "maxQueueSize", value = "10"),
        }
    )
    public Song getSongByID(Long songID)
    {
        Song song = restTemplate.getForObject("http://music-information-service/songs/"+songID, Song.class);
        return song;
    }

    public Song getSongsByIDFallback(Long songID)
    {
        return new Song(songID, "", "", new Album());
    }

    @HystrixCommand(
        fallbackMethod = "getSongsFallback",
        threadPoolKey = "getSongs",
        threadPoolProperties = {
                @HystrixProperty(name = "coreSize", value = "100"),
                @HystrixProperty(name = "maxQueueSize", value = "50"),
        }
    )
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

    public List<Song> getSongsFallback()
    {
        List<Song> songs = new ArrayList<>();
        return songs;
    }


}
