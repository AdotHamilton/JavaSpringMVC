package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;
@Service
public class BookService {
 // adding the book repository as a dependency
	private final BookRepository bookRepository;
 
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
 // returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
 // creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
 // retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}	
	}
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
//	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages, Book book) {
//		Optional<Book> b = bookRepository.findById(id);
//		if(b.isPresent()) {
//			Book updatedBook = b.get();
//			updatedBook.setTitle(title);
//			updatedBook.setDescription(desc);
//			updatedBook.setLanguage(lang);
//			updatedBook.setNumberOfPages(numOfPages);
//			
//			return bookRepository.save(updatedBook);
//		} else {
//			return null;
//		}
//	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
}
