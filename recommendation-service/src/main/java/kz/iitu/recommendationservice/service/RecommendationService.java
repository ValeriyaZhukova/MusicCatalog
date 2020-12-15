package kz.iitu.recommendationservice.service;

import kz.iitu.recommendationservice.model.Recommendation;
import kz.iitu.recommendationservice.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {

    Recommendation recommendation;

    public Recommendation getRecommendedSongs()
    {
        Song song1 = new Song(1L, "Heat-shaped box", "Nevermind", "Nirvana");
        Song song2 = new Song(2L, "Bohemian Rhapsody", "A night at the opera", "Queen");
        Song song3 = new Song(3L, "Yesterday", "Single", "The Beatles");

        List<Song> recommendations = new ArrayList<>();
        recommendations.add(song1);
        recommendations.add(song2);
        recommendations.add(song3);

        recommendation.setRecommendedSongs(recommendations);

        return recommendation;
    }
}
