package kz.iitu.musicinformationservice.model;


import lombok.*;
import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Lyrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @OneToOne
    @MapsId
    private Song song;

    @NonNull
    private String lyrics;
}
