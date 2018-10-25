package com.comp586server;

import com.comp586server.domain.Author;
import com.comp586server.domain.Book;
import com.comp586server.repository.AuthorRepository;
import com.comp586server.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class Comp586serverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Comp586serverApplication.class, args);
	}

	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookRepository bookRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Optional<Author> byId = authorRepository.findById(1);
		Author author = byId.get();
		System.out.println("cool");

		Optional<Book> byId1 = bookRepository.findById(1);
		Book book = byId1.get();
		System.out.println("HELP");
//		Set<Book> bookSet = new HashSet<>();
//
//		Book book = new Book();
//		book.setName("Romeo and Juliet");
//		book.setAuthor(author);
//		bookSet.add(book);
//
//		book = new Book();
//		book.setName("Hamlet");
//		book.setAuthor(author);
//		bookSet.add(book);
//
//		book = new Book();
//		book.setName("Macbeth");
//		book.setAuthor(author);
//		bookSet.add(book);
//
//		author.setBooks(bookSet);
//
//		authorRepository.save(author);
//		bookRepository.saveAll(bookSet);
	}
}
