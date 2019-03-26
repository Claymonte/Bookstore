package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.web.Category;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.web.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByLastnameShouldReturnStudent() {
        List<Book> books = repository.findByTitle("Hobitti");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Hobitti");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("50 Shades of Gray", "K.Wickholm", 2016, 123456, 20.00, new Category("Romance"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}
