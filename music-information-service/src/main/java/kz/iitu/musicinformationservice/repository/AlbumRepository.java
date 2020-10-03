package kz.iitu.musicinformationservice.repository;

import kz.iitu.musicinformationservice.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
