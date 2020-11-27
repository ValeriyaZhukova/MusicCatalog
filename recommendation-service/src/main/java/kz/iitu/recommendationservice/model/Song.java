package kz.iitu.recommendationservice.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class Song {

    private Long id;
    private String title;
    private String album;
    private String artist;

}

