package kz.iitu.musicinformationservice.repository;

import kz.iitu.musicinformationservice.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long>{

    List<Song> findSongsByTitleContaining(String title);

    List<Song> findSongByAlbum_NameContaining(String album_name);

    List<Song> findSongByAlbumId(Long album_id);

    List<Song> findSongByArtists_NameContaining(String artist_name);

    List<Song> findSongByAlbum_Genre_Genre(String album_genre);

}
