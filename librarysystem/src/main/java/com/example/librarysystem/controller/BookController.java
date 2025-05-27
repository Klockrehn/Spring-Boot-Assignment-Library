package com.example.librarysystem.controller;

import com.example.librarysystem.dto.BookDTO;
import com.example.librarysystem.entity.Book;
import com.example.librarysystem.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public List<BookDTO> searchBooks(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }

    @PostMapping
    public BookDTO createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
}
