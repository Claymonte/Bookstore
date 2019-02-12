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
	
		public CommandLineRunner demo(BookRepository repository){
			return (args) -> {
				
				repository.save(new Book("book1", "J.R.R Tolkien",0000, 123456, 20.00));
				repository.save(new Book("book2","IT",0000,55555,25.00));
				repository.save(new Book("book3","How to start a business",8888,11111,34.00));
				repository.save(new Book("book4","HTML basics",4444,00000,50.00));
		
			
	};
		}
	}


