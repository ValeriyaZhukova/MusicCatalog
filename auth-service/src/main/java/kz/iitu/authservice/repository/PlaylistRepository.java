package kz.iitu.authservice.repository;

import kz.iitu.authservice.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    public List<Playlist> findByUserId(Long id);
}
