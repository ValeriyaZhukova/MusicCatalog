package kz.iitu.musicinformationservice;

import lombok.*;
import javax.persistence.*;

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

}