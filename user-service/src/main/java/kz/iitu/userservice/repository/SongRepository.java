package kz.iitu.userservice.repository;

import kz.iitu.userservice.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
