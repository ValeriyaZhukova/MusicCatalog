package kz.iitu.musicinformationservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "requests", "songs"})
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private int year;
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
