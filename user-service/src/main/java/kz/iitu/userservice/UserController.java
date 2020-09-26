package kz.iitu.userservice;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    UserRepository userRepository;

    @GetMapping("")
    public User getUserById(@RequestParam String username)
    {
        return userRepository.findUserByUsername(username);
    }
}
