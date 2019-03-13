package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;
import com.example.Bookstore.web.BookRepository;
import com.example.Bookstore.web.Category;
import com.example.Bookstore.web.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			// Create users: admin/admin user/user
			User user1 = new User("user"
			,
			"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin"
			,
			"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
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
