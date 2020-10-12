package kz.iitu.userservice.service;

import kz.iitu.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Component
public class AuthService {

    @Autowired
    RestTemplate restTemplate;

    public void login(User user)
    {
        ResponseEntity<User> response = restTemplate.postForEntity("http://auth-service/users/login", user, User.class);

        // check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println("Request Failed");
        }
    }

   /* public void register(String username, String email, String password)
    {
        ResponseEntity<User> response = restTemplate.postForEntity("http://auth-service/users/login", user, User.class);

        // check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println("Request Failed");
        }
    }*/
}
