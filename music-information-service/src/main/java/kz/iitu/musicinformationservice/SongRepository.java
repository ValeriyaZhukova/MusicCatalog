package kz.iitu.musicinformationservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long>{

    Song getSongById(Long id);

    List<Song> findAll();

    List<Song> findSongsByTitleContaining(String title);
}
