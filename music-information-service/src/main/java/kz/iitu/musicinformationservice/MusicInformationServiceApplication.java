package kz.iitu.musicinformationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MusicInformationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicInformationServiceApplication.class, args);
    }

}
