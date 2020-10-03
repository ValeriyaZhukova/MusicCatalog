package kz.iitu.musicinformationservice.repository;

import kz.iitu.musicinformationservice.model.Lyrics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LyricsRepository extends JpaRepository<Lyrics, Long> {
}
