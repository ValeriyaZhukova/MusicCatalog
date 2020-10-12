package kz.iitu.userservice.controller;

import kz.iitu.userservice.model.User;
import kz.iitu.userservice.service.AuthService;
import kz.iitu.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @GetMapping("")
    public List<User> getUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id)
    {
        return userService.getUserByID(id);
    }

    @PostMapping("/login")
    public void login(@RequestBody User user)
    {
        authService.login(user);
    }
}
