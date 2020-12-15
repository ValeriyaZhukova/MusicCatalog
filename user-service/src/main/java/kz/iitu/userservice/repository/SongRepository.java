package kz.iitu.userservice.repository;

import kz.iitu.userservice.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

}
