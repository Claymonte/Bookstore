package com.example.Bookstore.web;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.Bookstore.domain.Book;

//by extending CrudReposity we can use several methods for saving, deleting, and finding book entities.
@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book,Long> {
	//defining query method
	List<Book>findByTitle(@Param("title") String Title);
	
}
