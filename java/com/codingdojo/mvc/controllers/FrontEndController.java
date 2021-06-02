package com.codingdojo.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;
@Controller
public class FrontEndController {
	private final BookService bookService;
	 public FrontEndController(BookService bookService){
	     this.bookService = bookService;
	 }
	@RequestMapping("/")
	public String index() {
		return "Index.jsp";
	}
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book b = bookService.findBook(id);
		model.addAttribute("book", b);
		return "show.jsp";
	}
	
	@RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }
    
  
	
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
}
