package kz.iitu.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "playlists"})
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String length;

    @OneToOne(mappedBy = "song", cascade = CascadeType.ALL)
    private Lyrics lyrics;

    @NonNull
    @ManyToOne
    @JoinColumn(name="album_id", nullable=false)
    private Album album;

    @ManyToMany
    @JoinTable(
            name = "songs_artists",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    List<Artist> artists;

    @ManyToMany(mappedBy = "songList", fetch = FetchType.LAZY)
    List<Playlist> playlists;

}