package kz.iitu.musicinformationservice.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String genre;

    @OneToMany(mappedBy="genre")
    private List<Album> albums;
}
