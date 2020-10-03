package kz.iitu.musicinformationservice.service;

import kz.iitu.musicinformationservice.model.Song;
import kz.iitu.musicinformationservice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
@Component
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public Song getSongByID(Long id)
    {
        return songRepository.findById(id).get();
    }

    public List<Song> getAllSongs()
    {
        return songRepository.findAll();
    }

    public List<Song> getSongsByTitle(String title)
    {
        return songRepository.findSongsByTitleContaining(title);
    }

    public List<Song> getSongsByAlbum(String album_name)
    {
        return songRepository.findSongByAlbum_NameContaining(album_name);
    }

    public List<Song> getSongsByArtist(String artist_name)
    {
        return songRepository.findSongByArtists_NameContaining(artist_name);
    }

    public List<Song> getSongsByGenre(String genre)
    {
        return songRepository.findSongByAlbum_Genre_Genre(genre);
    }

    public void addSong(Song song)
    {
        songRepository.saveAndFlush(song);
    }


    public void updateSong(Long id, Song song)
    {
        Song songDb = songRepository.findById(id).orElse(null);

        if(songDb != null)
        {
            songDb.setTitle(song.getTitle());
            songDb.setLength(song.getLength());
            songDb.setAlbum(song.getAlbum());
            songDb.setLyrics(song.getLyrics());
            songDb.setArtists(song.getArtists());

            songRepository.saveAndFlush(songDb);
        }
    }

    public void deleteSong(Long id)
    {
        Song song = new Song();
        song.setId(id);
        songRepository.delete(song);
    }
}
