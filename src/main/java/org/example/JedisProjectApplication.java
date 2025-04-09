package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class JedisProjectApplication {

    @Autowired
    private RedisSeeder redisSeeder;

    public static void main(String[] args) {
        SpringApplication.run(JedisProjectApplication.class, args);
    }

    @PostConstruct
    public void init() {
        redisSeeder.seedIfNeeded();
    }
}
