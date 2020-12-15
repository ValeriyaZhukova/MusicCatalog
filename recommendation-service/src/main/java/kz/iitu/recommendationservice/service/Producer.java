package kz.iitu.recommendationservice.service;

import kz.iitu.recommendationservice.model.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "recommendation";

    @Autowired
    private KafkaTemplate<String, Recommendation> kafkaTemplate;

    public String newRecommendationAddedNotification(Recommendation recommendation) {
        System.out.println(String.format("#### -> Producing book request to notification service -> %s", recommendation));
        this.kafkaTemplate.send(TOPIC, recommendation);
        return "Success";
    }
}