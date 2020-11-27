package kz.iitu.recommendationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Playlist {

    Long id;
    String name;
    private User user;

}
