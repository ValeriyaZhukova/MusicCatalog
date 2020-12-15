package kz.iitu.musiccatalog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.musiccatalog.model.Album;
import kz.iitu.musiccatalog.model.Genre;
import kz.iitu.musiccatalog.model.Song;
import kz.iitu.musiccatalog.model.SongList;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://music-information-service/songs/" + songID,
                HttpMethod.GET, entity, Song.class).getBody();
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
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Song>> response = restTemplate.exchange(
                "http://music-information-service/songs",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Song>>(){});

        List<Song> songs = response.getBody();
        return songs;

    }

    public List<Song> getSongsFallback()
    {
        Genre genre = new Genre(0L, "null");
        Album album = new Album(0L, "null", 0, "null", 0);
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(0L, "null", "null", album));
        return songs;
    }

    @HystrixCommand(
            fallbackMethod = "getSongsByAlbumIDFallback",
            threadPoolKey = "getSongsByAlbumID",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            }
    )
    public List<Song> getSongsByAlbumID(Long album_id)
    {
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Song>> response = restTemplate.exchange(
                "http://music-information-service/songs/album/"+album_id,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Song>>(){});

        List<Song> songs = response.getBody();
        return songs;
    }

    public List<Song> getSongsByAlbumIDFallback(Long album_id)
    {
        Genre genre = new Genre(0L, "null");
        Album album = new Album(album_id, "null", 0, "null", 0);
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(0L, "null", "null", album));
        return songs;
    }

    @HystrixCommand(
            fallbackMethod = "getAlbumsFallback",
            threadPoolKey = "getAlbums",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            }
    )
    public List<Album> getAlbums()
    {
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Album>> response = restTemplate.exchange(
                "http://music-information-service/albums",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Album>>(){});

        List<Album> albums = response.getBody();
        return albums;
    }

    public List<Album> getAlbumsFallback()
    {
        return new ArrayList<Album>();
    }

    @HystrixCommand(
            fallbackMethod = "getAlbumByIDFallback",
            threadPoolKey = "getAlbumByID",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            }
    )
    public Album getAlbumByID(Long albumID)
    {
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://music-information-service/albums/" + albumID,
                HttpMethod.GET, entity, Album.class).getBody();
    }

    public Album getAlbumByIDFallback(Long albumID)
    {
        return new Album();
    }



}
