package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.web.BookRepository;
import com.example.Bookstore.web.Category;
import com.example.Bookstore.web.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Animals"));
			crepository.save(new Category("Programming"));

			brepository.save(new Book("Hobitti", "K. Wickholm", 2018, 123456, 20.00, crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("Muumit", "K. Wickholm", 2011, 1234567, 25.00, crepository.findByName("Fiction").get(0)));
			brepository.save(new Book("Koirankasvatus", "K. Wickholm", 2015, 12345678, 34.00, crepository.findByName("Animals").get(0)));
			brepository.save(new Book("Koodaamisen alkeet", "K. Wickholm", 1987, 1234556789, 50.00, crepository.findByName("Programming").get(0)));

		}; 
	}
}
