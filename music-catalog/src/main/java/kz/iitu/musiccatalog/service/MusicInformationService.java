package kz.iitu.musiccatalog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.musiccatalog.model.Song;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MusicInformationService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(
        threadPoolKey = "getAllSongs",
        threadPoolProperties = {
                @HystrixProperty(name="coreSize", value="100"),
                @HystrixProperty(name="maximumSize", value="120"),
                @HystrixProperty(name="maxQueueSize", value="50"),
                @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
        }
    )
    public Song getSongs()
    {
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<Song> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://music-information-service/songs",
                HttpMethod.GET, entity, Song.class).getBody();
    }

    @HystrixCommand(
            threadPoolKey = "getSongById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maximumSize", value="120"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
            }
    )
    public Song getSongById(Long songId)
    {
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://music-information-service/songs/" + songId,
                HttpMethod.GET, entity, Song.class).getBody();
    }
}
