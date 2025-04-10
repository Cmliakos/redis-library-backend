package org.example;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.*;

@Service
public class BookService {
    private final Jedis jedis;

    public BookService() {
        this.jedis = new Jedis("maximum-collie-10229.upstash.io", 6379, true);
        this.jedis.auth("default", "ASf1AAIjcDExZDAyZDdmNDY5YzY0N2ZjYmU3MDI3YzE3ZDljNWVmYXAxMA");

    }

    public List<Map<String, String>> getAllBooks(String sortBy) {
        Set<String> keys = jedis.smembers("bookIds");
        List<Map<String, String>> books = new ArrayList<>();

        for (String key : keys) {
            Map<String, String> book = jedis.hgetAll(key);
            book.put("id", key);  // include the Redis key for lookup later
            book.put("views", jedis.get("views:" + key) != null ? jedis.get("views:" + key) : "0");
            book.put("favorites", String.valueOf(jedis.scard("favoritedBy:" + key)));
            book.put("isFavorite", jedis.sismember("favorites:user1", key) ? "true" : "false");
            books.add(book);
        }

        switch (sortBy) {
            case "title_asc" -> books.sort(Comparator.comparing(b -> b.getOrDefault("title", "")));
            case "title_desc" -> books.sort(Comparator.comparing((Map<String, String> b) -> b.getOrDefault("title", "")).reversed());
            case "price_low" -> books.sort(Comparator.comparingDouble(b -> parsePrice(b.get("price"))));
            case "price_high" -> books.sort(Comparator.comparingDouble((Map<String, String> b) -> parsePrice(b.get("price"))).reversed());
            case "views_desc" -> books.sort(Comparator.comparingInt(b -> -Integer.parseInt(b.getOrDefault("views", "0")))
            );
        }

        return books;
    }

    private double parsePrice(String priceStr) {
        if (priceStr == null) return 0.0;
        try {
            return Double.parseDouble(priceStr.replace("$", ""));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public String getBookDetail(String bookName) {
        jedis.incr("views:" + bookName);
        jedis.zincrby("topViewed", 1, bookName);

        String description = jedis.hget(bookName, "description");
        String price = jedis.hget(bookName, "price");
        String author = jedis.hget(bookName, "author");
        String views = jedis.get("views:" + bookName);

        return String.format("Description: %s\nPrice: %s\nAuthor: %s\nViews: %s",
                description, price, author, views);
    }

    public List<String> getTopViewedBooks() {
        return new ArrayList<>(jedis.zrevrange("topViewed", 0, 2));
    }

    public void addFavorite(String userId, String bookId) {
        jedis.sadd("favorites:" + userId, bookId);
        jedis.sadd("favoritedBy:" + bookId, userId);
    }

    public void removeFavorite(String userId, String bookId) {
        jedis.srem("favorites:" + userId, bookId);
        jedis.srem("favoritedBy:" + bookId, userId);
    }

    public Set<String> getUserFavorites(String userId) {
        return jedis.smembers("favorites:" + userId);
    }
}

