package kz.iitu.musiccatalog.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "playlist_id", referencedColumnName = "id")
    private MainPlaylist playlist;

}
