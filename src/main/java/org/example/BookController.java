package org.example;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Map<String, String>> getAllBooks(@RequestParam(required = false, defaultValue = "title_asc") String sort) {
        return bookService.getAllBooks(sort);
    }

    @GetMapping("/bookDetails")
    public String getBookDetails(@RequestParam String bookName) {
        return bookService.getBookDetail(bookName);
    }

    @GetMapping("/topBooks")
    public List<String> getTopBooks() {
        return bookService.getTopViewedBooks();
    }

    @PostMapping("/favorite")
    public void favoriteBook(@RequestParam String userId, @RequestParam String bookId) {
        bookService.addFavorite(userId, bookId);
    }

    @PostMapping("/unfavorite")
    public void unfavoriteBook(@RequestParam String userId, @RequestParam String bookId) {
        bookService.removeFavorite(userId, bookId);
    }

    @GetMapping("/favorites")
    public Set<String> getUserFavorites(@RequestParam String userId) {
        return bookService.getUserFavorites(userId);
    }
}


