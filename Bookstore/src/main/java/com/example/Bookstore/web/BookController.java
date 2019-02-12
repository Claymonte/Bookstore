package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	@RequestMapping(value="/index")
		public String getIndex() {
		return "index";

	}
	 @RequestMapping(value ="/booklist")
	    public String bookList(Model model) {	
	        return "booklist";

}
	 
}