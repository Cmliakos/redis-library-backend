package org.example;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisSeeder {

    private final Jedis jedis;

    public RedisSeeder() {
        this.jedis = new Jedis("maximum-collie-10229.upstash.io", 6379, true);
        jedis.auth("default", "ASf1AAIjcDExZDAyZDdmNDY5YzY0N2ZjYmU3MDI3YzE3ZDljNWVmYXAxMA");
    }

    public void seedIfNeeded() {
        // If key doesn't exist, Redis was likely wiped — seed everything
        if (!"true".equals(jedis.get("dataSeeded"))) {
            System.out.println("Redis empty — seeding books...");

            // Book 1
            jedis.hset("book1", "title", "To Kill a Mockingbird");
            jedis.hset("book1", "author", "Harper Lee");
            jedis.hset("book1", "description", "A gripping, heart-wrenching, and wholly remarkable tale of coming-of-age in a South poisoned by prejudice.");
            jedis.hset("book1", "price", "$12.99");
            jedis.hset("book1", "imageUrl", "https://redis-library-backend.onrender.com/images/book1.jpg");

            // Book 2
            jedis.hset("book2", "title", "The Hobbit");
            jedis.hset("book2", "author", "J.R.R. Tolkien");
            jedis.hset("book2", "description", "Bilbo Baggins embarks on a journey to reclaim treasure from the dragon Smaug.");
            jedis.hset("book2", "price", "$14.99");
            jedis.hset("book2", "imageUrl", "https://redis-library-backend.onrender.com/images/book2.jpg");

            // Book 3
            jedis.hset("book3", "title", "1984");
            jedis.hset("book3", "author", "George Orwell");
            jedis.hset("book3", "description", "A dystopian novel set in a totalitarian society ruled by Big Brother.");
            jedis.hset("book3", "price", "$11.50");
            jedis.hset("book3", "imageUrl", "https://redis-library-backend.onrender.com/images/book3.jpg");

            // Book 4
            jedis.hset("book4", "title", "Fahrenheit 451");
            jedis.hset("book4", "author", "Ray Bradbury");
            jedis.hset("book4", "description", "A novel about a future society where books are outlawed and burned.");
            jedis.hset("book4", "price", "$13.25");
            jedis.hset("book4", "imageUrl", "https://redis-library-backend.onrender.com/images/book4.jpg");

            // Book 5
            jedis.hset("book5", "title", "The Old Man and the Sea");
            jedis.hset("book5", "author", "Ernest Hemingway");
            jedis.hset("book5", "description", "An aging fisherman engages in an epic battle to catch a giant marlin.");
            jedis.hset("book5", "price", "$9.99");
            jedis.hset("book5", "imageUrl", "https://redis-library-backend.onrender.com/images/book5.jpg");

            // Set flag
            jedis.set("dataSeeded", "true");
            System.out.println("Books seeded successfully.");
        } else {
            System.out.println("Redis already seeded. Skipping...");
        }
    }
}
