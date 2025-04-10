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
        System.out.println("🔁 Checking Redis for missing books...");

        seedBook("book1", "To Kill a Mockingbird", "Harper Lee",
                "A gripping, heart-wrenching, and wholly remarkable tale of coming-of-age in a South poisoned by prejudice.",
                "$12.99", "https://redis-library-backend.onrender.com/images/book1.jpg");

        seedBook("book2", "The Hobbit", "J.R.R. Tolkien",
                "Bilbo Baggins embarks on a journey to reclaim treasure from the dragon Smaug.",
                "$14.99", "https://redis-library-backend.onrender.com/images/book2.jpg");

        seedBook("book3", "1984", "George Orwell",
                "A dystopian novel set in a totalitarian society ruled by Big Brother.",
                "$11.50", "https://redis-library-backend.onrender.com/images/book3.jpg");

        seedBook("book4", "Fahrenheit 451", "Ray Bradbury",
                "A novel about a future society where books are outlawed and burned.",
                "$13.25", "https://redis-library-backend.onrender.com/images/book4.jpg");

        seedBook("book5", "The Old Man and the Sea", "Ernest Hemingway",
                "An aging fisherman engages in an epic battle to catch a giant marlin.",
                "$9.99", "https://redis-library-backend.onrender.com/images/book5.jpg");

        seedBook("book6", "Pride and Prejudice", "Jane Austen",
                "A romantic novel that charts the emotional development of the protagonist, Elizabeth Bennet.",
                "$10.99", "https://redis-library-backend.onrender.com/images/book6.jpg");

        seedBook("book7", "Jane Eyre", "Charlotte Brontë",
                "A novel that follows the experiences of its eponymous heroine, including her growth to adulthood and her love for Mr. Rochester.",
                "$11.99", "https://redis-library-backend.onrender.com/images/book7.jpg");

        seedBook("book8", "The Great Gatsby", "F. Scott Fitzgerald",
                "A story of the mysteriously wealthy Jay Gatsby and his love for the beautiful Daisy Buchanan.",
                "$15.99", "https://redis-library-backend.onrender.com/images/book8.jpg");

        seedBook("book9", "Animal Farm", "George Orwell",
                "A satirical allegory of the Russian Revolution and the rise of Stalinism.",
                "$8.99", "https://redis-library-backend.onrender.com/images/book9.jpg");

        seedBook("book10", "Le Comte de Monte-Cristo", "Alexandre Dumas",
                "The story of an unjustly incarcerated man who escapes to find revenge.",
                "$12.50", "https://redis-library-backend.onrender.com/images/book10.jpg");
    }

    private void seedBook(String key, String title, String author, String description, String price, String imageUrl) {
        if (!jedis.exists(key)) {
            System.out.println("📚 Seeding: " + title);
            jedis.hset(key, "title", title);
            jedis.hset(key, "author", author);
            jedis.hset(key, "description", description);
            jedis.hset(key, "price", price);
            jedis.hset(key, "imageUrl", imageUrl);
        } else {
            System.out.println("✅ Already exists: " + title);
        }

        // Always add the book key to the set (even if it already exists)
        jedis.sadd("bookIds", key);
    }
}

