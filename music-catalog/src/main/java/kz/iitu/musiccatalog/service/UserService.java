package kz.iitu.musiccatalog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.musiccatalog.model.Album;
import kz.iitu.musiccatalog.model.Song;
import kz.iitu.musiccatalog.model.User;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getUserByIDFallback",
            threadPoolKey = "getUserByID",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
            }
    )
    public User getUserByID(Long userID)
    {
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://user-service/users/" + userID,
                HttpMethod.GET, entity, User.class).getBody();
    }

    public User getUserByIDFallback(Long userID)
    {
        return new User();
    }


   /* public void login(User user)
    {
        ResponseEntity<User> response = restTemplate.postForEntity("http://user-service/users/login", user, User.class);

        // check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println("Request Failed");
        }
    }*/


}
