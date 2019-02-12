package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.Book;

@Controller
public class BookController {
	//index sivu
	@RequestMapping(value = "/index")
	public String getIndex() {
		return "index";

	}

	// kirjojen listaus
	@RequestMapping(value = "/booklist")
	public String bookList(Model model) {
		return "booklist";

	}
	// kirjojen lisäys
	@RequestMapping(value = "/addbook")
	    public String addStudent(Model model){
	    	model.addAttribute("book", new Book());
	        return "addbook";
}
	//Syötetyn kirjan tallennus tietokantaan
	 @RequestMapping(value="/savebook",method =RequestMethod.POST)
	    public String save(Book book){
	    	return "redirect:booklist";
	    }
}