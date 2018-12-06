package com.comp586server;

import com.comp586server.repository.AuthorRepository;
import com.comp586server.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.transaction.Transactional;
import java.util.Collections;

@EnableResourceServer
@SpringBootApplication
public class Comp586serverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Comp586serverApplication.class, args);
	}

	@Bean
	@SuppressWarnings("unchecked")
	public FilterRegistrationBean simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookRepository bookRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {

//		Author author = new Author();
//		author.setName("George Orwell");
//
//
//		Set<Book> bookSet = new HashSet<>();
//
//		Book book = new Book();
//		book.setName("1984");
//		book.setAuthor(author);
//		bookSet.add(book);
//
//		book = new Book();
//		book.setName("Harry Potter and the Chamber of Secrets");
//		book.setAuthor(author);
//		bookSet.add(book);
//
//		book = new Book();
//		book.setName("Harry Potter and the Prisoner of Azkaban");
//		book.setAuthor(author);
//		bookSet.add(book);
//
//		book = new Book();
//		book.setName("Harry Potter and the Half-Blood Prince");
//		book.setAuthor(author);
//		bookSet.add(book);
//
//		book = new Book();
//		book.setName("Harry Potter and the Order of the Phoenix");
//		book.setAuthor(author);
//		bookSet.add(book);
//
//		book = new Book();
//		book.setName("Harry Potter and the Goblet of Fire");
//		book.setAuthor(author);
//		bookSet.add(book);
//
//		book = new Book();
//		book.setName("Harry Potter and the Deathly Hallows");
//		book.setAuthor(author);
//		bookSet.add(book);

//		author.setBooks(bookSet);

//		authorRepository.save(author);
//		bookRepository.saveAll(bookSet);
	}
}
