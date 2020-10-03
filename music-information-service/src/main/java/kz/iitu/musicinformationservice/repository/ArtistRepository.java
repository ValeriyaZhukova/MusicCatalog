package kz.iitu.musicinformationservice.repository;

import kz.iitu.musicinformationservice.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
