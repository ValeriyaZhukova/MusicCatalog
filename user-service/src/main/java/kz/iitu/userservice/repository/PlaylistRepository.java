package kz.iitu.userservice.repository;

import kz.iitu.userservice.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    public List<Playlist> findByUserId(Long id);

    public List<Playlist> findByNameContaining(String name);
}
