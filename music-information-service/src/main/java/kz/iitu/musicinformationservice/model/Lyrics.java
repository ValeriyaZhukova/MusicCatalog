package kz.iitu.musicinformationservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "requests", "song"})
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
