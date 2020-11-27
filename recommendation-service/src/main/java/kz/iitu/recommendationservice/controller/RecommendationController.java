package kz.iitu.recommendationservice.controller;

import kz.iitu.recommendationservice.service.Producer;
import kz.iitu.recommendationservice.model.Recommendation;
import kz.iitu.recommendationservice.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/recommendations")
public class RecommendationController {

    @Autowired
    private final Producer producer;
    private RecommendationService recommendationService;

    @Autowired
    public RecommendationController(Producer producer, RecommendationService recommendationService) {
        this.producer = producer;
        this.recommendationService = recommendationService;
    }

    @GetMapping
    public String sendMessageToKafkaTopic()
    {
        Recommendation recommendation = new Recommendation();
        this.producer.newRecommendationAddedNotification(recommendation);
        return "You have received new song recommendations!";
    }
}
