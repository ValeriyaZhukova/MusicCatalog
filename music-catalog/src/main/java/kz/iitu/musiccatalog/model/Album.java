package kz.iitu.musiccatalog.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "songs"})
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private int publication_year;
    @NonNull
    private String length;
    @NonNull
    private int n_tracks;

    @OneToMany(mappedBy="album")
    private List<Song> songs;

    @ManyToOne
    @JoinColumn(name="genre_id", nullable=false)
    private Genre genre;
}
