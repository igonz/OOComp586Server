package com.comp586server.controller;

import com.comp586server.domain.Author;
import com.comp586server.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthorController {
    private AuthorRepository repository;

    @Autowired
    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getAuthor")
    public Author getAuthor(@RequestParam String id) {
        try{
            Integer integer = Integer.valueOf(id);
            Optional<Author> authorById = repository.findById(integer);
            if(authorById.isPresent()) {
                return authorById.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/getAllAuthors")
    public Iterable<Author> getAllAuthors() {
        return repository.findAll();
    }
}
