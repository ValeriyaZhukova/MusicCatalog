package kz.iitu.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Recommendation {

    private User user;
    private Song song;
    private Playlist playlist;
    private List<Song> recommendedSongs = new ArrayList<>();
}
