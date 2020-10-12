package kz.iitu.authservice.controller;

import kz.iitu.authservice.model.User;
import kz.iitu.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register/")
    public User createUserByUsernamePassword(@RequestParam String username, @RequestParam String email, @RequestParam String password)
    {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);

        userService.createUser(user);
        User newUser = (User) userService.loadUserByUsername(username);
        return newUser;
    }

    @GetMapping("/find/")
    public User findByUsername(@RequestParam String username)
    {
        User user = null;
        user = (User) userService.loadUserByUsername(username);

        return user;
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        userService.updateUser(id, user);
        User userDB = (User) userService.loadUserByUsername(user.getUsername());
        return userDB;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
