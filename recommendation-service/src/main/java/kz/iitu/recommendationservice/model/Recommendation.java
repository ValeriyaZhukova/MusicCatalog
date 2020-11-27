package kz.iitu.recommendationservice.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Recommendation {

    private User user;
    private Song song;
    private Playlist playlist;
    private List<Song> recommendedSongs = new ArrayList<>();

}
