package kz.iitu.musicinformationservice.repository;

import kz.iitu.musicinformationservice.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
