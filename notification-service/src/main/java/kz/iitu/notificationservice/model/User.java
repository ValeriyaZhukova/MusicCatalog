package kz.iitu.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private List<Playlist> playlists;

}
