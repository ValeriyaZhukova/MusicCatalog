package kz.iitu.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kz.iitu.userservice.model.Song;
import kz.iitu.userservice.model.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "user"})
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NonNull
    String name;

    @ManyToOne
    @NonNull
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "songs_playlists",
            joinColumns = {
                    @JoinColumn(name = "playlist_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "song_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Song> songList = new ArrayList<>();*/


}
