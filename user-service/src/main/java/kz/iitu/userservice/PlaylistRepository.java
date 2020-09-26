package kz.iitu.userservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<MainPlaylist, Long> {

    public MainPlaylist findMainPlaylistByUserId(Long userId);

}
