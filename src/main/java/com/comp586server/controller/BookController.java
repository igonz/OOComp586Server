package com.comp586server.controller;

import com.comp586server.domain.Book;
import com.comp586server.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getAllBooks")
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
