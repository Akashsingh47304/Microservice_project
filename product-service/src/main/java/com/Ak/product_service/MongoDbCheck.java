package com.Ak.product_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoDbCheck implements CommandLineRunner {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    Environment environment;



    @Override
    public void run(String... args) {
        System.out.println(environment.getProperty("spring.data.mongodb.uri"));
        System.out.println("Connected Database = " + mongoTemplate.getDb().getName());
    }
}
