package com.example.Bookstore.web;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.Bookstore.domain.Book;

//by extending CrudReposity we can use several methods for saving, deleting, and finding book entities.
public interface BookRepository extends CrudRepository<Book,Long> {
	//defining query method
	List<Book>findByTitle(String Title);


	
}
