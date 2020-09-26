package kz.iitu.musiccatalog.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MainPlaylist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(mappedBy = "playlist")
    private User user;

    @OneToMany(mappedBy="playlist")
    private List<Song> songs;
}
