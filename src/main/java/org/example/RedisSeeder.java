package org.example;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisSeeder {

    private final Jedis jedis;

    public RedisSeeder() {
        this.jedis = new Jedis("maximum-collie-10229.upstash.io", 6379, true);
        this.jedis.auth("default", "ASf1AAIjcDExZDAyZDdmNDY5YzY0N2ZjYmU3MDI3YzE3ZDljNWVmYXAxMA");
    }

    public void seedIfNeeded() {
        if (!jedis.exists("book1")) {
            // Book 1
            jedis.hset("book1", "title", "To Kill a Mockingbird");
            jedis.hset("book1", "author", "Harper Lee");
            jedis.hset("book1", "description", "A gripping, heart-wrenching tale of prejudice and coming-of-age.");
            jedis.hset("book1", "price", "$12.99");
            jedis.hset("book1", "imageUrl", "https://redis-library-backend.onrender.com/images/book1.jpg");

            // Book 2
            jedis.hset("book2", "title", "The Hobbit");
            jedis.hset("book2", "author", "J.R.R. Tolkien");
            jedis.hset("book2", "description", "Bilbo Baggins embarks on a journey to reclaim treasure from Smaug.");
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
            jedis.hset("book4", "description", "A novel about a future where books are outlawed and burned.");
            jedis.hset("book4", "price", "$13.25");
            jedis.hset("book4", "imageUrl", "https://redis-library-backend.onrender.com/images/book4.jpg");

            // Book 5
            jedis.hset("book5", "title", "The Old Man and the Sea");
            jedis.hset("book5", "author", "Ernest Hemingway");
            jedis.hset("book5", "description", "An aging fisherman battles a giant marlin in an epic struggle.");
            jedis.hset("book5", "price", "$9.99");
            jedis.hset("book5", "imageUrl", "https://redis-library-backend.onrender.com/images/book5.jpg");

            System.out.println("RedisSeeder: Books seeded.");
        } else {
            System.out.println("RedisSeeder: Books already exist. Skipping seed.");
        }
    }
}
