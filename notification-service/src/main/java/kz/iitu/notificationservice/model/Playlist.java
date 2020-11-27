package kz.iitu.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Playlist {

    Long id;
    String name;
    private User user;

}
