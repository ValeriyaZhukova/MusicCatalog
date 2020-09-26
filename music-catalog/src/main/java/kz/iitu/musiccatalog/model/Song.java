package kz.iitu.musiccatalog.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String performer;
    @NonNull
    private String album;
    @NonNull
    private String release_year;

    @ManyToOne
    @JoinColumn(name="playlist_id", nullable=false)
    private MainPlaylist playlist;

}
