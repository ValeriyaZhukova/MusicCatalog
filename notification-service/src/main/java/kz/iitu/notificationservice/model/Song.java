package kz.iitu.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Song {

    private Long id;
    private String title;
    private String album;
    private String artist;

}
