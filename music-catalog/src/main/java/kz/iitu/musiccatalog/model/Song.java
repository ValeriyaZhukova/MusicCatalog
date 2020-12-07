package kz.iitu.musiccatalog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
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

    /*@ManyToMany(mappedBy = "songs", fetch = FetchType.LAZY)
    List<Playlist> playlists;*/

}