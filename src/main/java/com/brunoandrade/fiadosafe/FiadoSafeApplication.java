package com.brunoandrade.fiadosafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FiadoSafeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiadoSafeApplication.class, args);
    }

}
