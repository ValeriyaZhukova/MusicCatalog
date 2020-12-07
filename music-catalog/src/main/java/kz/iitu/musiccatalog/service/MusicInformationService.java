package kz.iitu.musiccatalog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.musiccatalog.model.Album;
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
    public SongList getSongs()
    {
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://music-information-service/songs",
                HttpMethod.GET, entity, SongList.class).getBody();

        /*return restTemplate.exchange("http://music-information-service/songs/",
                HttpMethod.GET, entity, Song.class).getBody();*/

        /*ResponseEntity<List<Song>> response = restTemplate.exchange(
                "http://localhost:8081/api/catalog/songs",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Song>>(){});

        List<Song> songs = response.getBody();
        return songs;*/
    }

    public SongList getSongsFallback()
    {
        Album album = new Album();
        SongList songList = new SongList();
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(0L, "", "", album));
        songList.setSongList(songs);
        return songList;
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
