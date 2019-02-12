package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.web.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository) {
		return (args) -> {

			brepository.save(new Book("Hobitti", "K. Wickholm", 2018, 951-98548-9-4, 20.00));
			brepository.save(new Book("Muumit", "K. Wickholm", 2011, 951-98548-9-3, 25.00));
			brepository.save(new Book("Koirankasvatus", "K. Wickholm", 2015, 951-98548-9-2, 34.00));
			brepository.save(new Book("Koodaamisen alkeet", "K. Wickholm", 1987, 951-98548-9-1, 50.00));

		}; 
	}
}
