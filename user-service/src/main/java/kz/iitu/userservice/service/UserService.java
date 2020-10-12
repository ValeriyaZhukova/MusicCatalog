package kz.iitu.userservice.service;

import kz.iitu.userservice.model.User;
import kz.iitu.userservice.repository.RoleRepository;
import kz.iitu.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository userRoleRepository;

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User getUserByID(Long id)
    {
        return userRepository.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findUserByUsername(username);

        if (user == null)
        {
            throw new UsernameNotFoundException("User: " + username + " not found!");
        }

        return user;
    }
}
