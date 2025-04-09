package org.example;

import redis.clients.jedis.Jedis;

public class RedisDataSetup {
    public static void main(String[] args) {
        // Connect to your Upstash Redis instance
        Jedis jedis = new Jedis("maximum-collie-10229.upstash.io", 6379, true);
        jedis.auth("default", "ASf1AAIjcDExZDAyZDdmNDY5YzY0N2ZjYmU3MDI3YzE3ZDljNWVmYXAxMA");

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

        // Book 6
        jedis.hset("book6", "title", "Pride and Prejudice");
        jedis.hset("book6", "author", "Jane Austen");
        jedis.hset("book6", "description", "A romantic novel that charts the emotional development of the protagonist, Elizabeth Bennet.");
        jedis.hset("book6", "price", "$10.99");
        jedis.hset("book6", "imageUrl", "https://redis-library-backend.onrender.com/images/book6.jpg");

        // Book 7
        jedis.hset("book7", "title", "Jane Eyre");
        jedis.hset("book7", "author", "Charlotte Brontë");
        jedis.hset("book7", "description", "A novel that follows the experiences of its eponymous heroine, including her growth to adulthood and her love for Mr. Rochester.");
        jedis.hset("book7", "price", "$11.99");
        jedis.hset("book7", "imageUrl", "https://redis-library-backend.onrender.com/images/book7.jpg");

        // Book 8
        jedis.hset("book8", "title", "The Great Gatsby");
        jedis.hset("book8", "author", "F. Scott Fitzgerald");
        jedis.hset("book8", "description", "A story of the mysteriously wealthy Jay Gatsby and his love for the beautiful Daisy Buchanan.");
        jedis.hset("book8", "price", "$15.99");
        jedis.hset("book8", "imageUrl", "https://redis-library-backend.onrender.com/images/book8.jpg");

        // Book 9
        jedis.hset("book9", "title", "Animal Farm");
        jedis.hset("book9", "author", "George Orwell");
        jedis.hset("book9", "description", "A satirical allegory of the Russian Revolution and the rise of Stalinism.");
        jedis.hset("book9", "price", "$8.99");
        jedis.hset("book9", "imageUrl", "https://redis-library-backend.onrender.com/images/book9.jpg");

        // Book 10
        jedis.hset("book10", "title", "Le Comte de Monte-Cristo");
        jedis.hset("book10", "author", "Alexandre Dumas");
        jedis.hset("book10", "description", "The work, which is set during the time of the Bourbon Restoration in France, tells the story of an unjustly incarcerated man who escapes to find revenge.");
        jedis.hset("book10", "price", "$12.50");
        jedis.hset("book10", "imageUrl", "https://redis-library-backend.onrender.com/images/book10.jpg");

        System.out.println("✅ RedisDataSetup: Books seeded into Redis.");
    }
}
