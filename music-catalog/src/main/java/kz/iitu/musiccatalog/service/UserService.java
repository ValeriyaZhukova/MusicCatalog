package kz.iitu.musiccatalog.service;

import kz.iitu.musiccatalog.model.Song;
import kz.iitu.musiccatalog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public void login(User user)
    {
        ResponseEntity<User> response = restTemplate.postForEntity("http://user-service/users/login", user, User.class);

        // check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println("Request Failed");
        }
    }
}
