package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.domain.Book;

@Controller
//@ResponseBody
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired CategoryRepository crepository;
	
	 @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	
	
	@RequestMapping(value="/index")
	public String getIndex() {
	return "index";
	}

	@RequestMapping(value = "/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@RequestMapping(value = "/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categorys", crepository.findAll());
		return "addbook";
	}

	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Book bookId, Model model) {
		repository.delete(bookId);
		return "redirect:booklist";
	}

	@RequestMapping(value="/edit{id}", method =RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId,Model model){
    	model.addAttribute("book",repository.findById(bookId));
    	model.addAttribute("categorys",crepository.findAll());
		return "editbook";

	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}

	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookid) {
		return repository.findById(bookid);
	}

}