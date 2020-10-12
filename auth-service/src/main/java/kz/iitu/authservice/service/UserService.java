package kz.iitu.authservice.service;

import kz.iitu.authservice.model.Playlist;
import kz.iitu.authservice.model.Role;
import kz.iitu.authservice.model.User;
import kz.iitu.authservice.repository.PlaylistRepository;
import kz.iitu.authservice.repository.RoleRepository;
import kz.iitu.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository userRoleRepository;

    @Autowired
    PlaylistRepository playlistRepository;

    public void createUser(User user)
    {
        List<Playlist> playlists = new ArrayList<>();
        List<Role> defaultRole = new ArrayList<>();
        defaultRole.add(userRoleRepository.findByRole("User"));

        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(defaultRole);
        userRepository.saveAndFlush(user);


        Playlist mainPlaylist = new Playlist("Main", user);
        playlists.add(mainPlaylist);
        playlistRepository.saveAndFlush(mainPlaylist);
        user.setPlaylists(playlists);
        userRepository.saveAndFlush(user);
    }

    public void updateUser(Long id, User user)
    {
        User userDb = userRepository.findById(id).orElse(null);

        if (userDb != null)
        {
            userDb.setUsername(user.getUsername());
            userDb.setEmail(user.getEmail());
            userDb.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.saveAndFlush(userDb);
        }
    }

    public void deleteUser(Long id)
    {
        User user = new User();
        user.setId(id);
        userRepository.delete(user);
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
