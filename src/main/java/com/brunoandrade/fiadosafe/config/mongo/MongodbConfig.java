package com.brunoandrade.fiadosafe.config.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongodbConfig {

    // mongodb://localhost:27017/Fiado-Safe

    @Value("${spring.data.mongodb.uri}")
    private String connectionString;

    @Bean
    public MongoDatabaseFactory mongoConfigure() {

        return new SimpleMongoClientDatabaseFactory(connectionString);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoConfigure());
    }
}
