package kz.iitu.notificationservice.service;

import kz.iitu.notificationservice.model.Recommendation;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    @KafkaListener(topics = "book_requests", groupId = "group_id")
    public void consume(Recommendation recommendation) throws IOException {
        System.out.println(String.format("#### -> Notify user: -> %s",
                "User " + recommendation.getUser().getId() + " have received "
                        + recommendation.getRecommendedSongs().size()
                        + "recommended songs "
        ));
    }
}
