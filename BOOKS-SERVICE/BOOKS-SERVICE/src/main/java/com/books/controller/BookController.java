package com.books.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.services.BookService;
import com.books.controller.Impl.BookControllerImpl;
import com.books.entities.*;

@Controller
@RequestMapping("/books")
public class BookController {
	
	private BookService booksService;
	private BookControllerImpl bookControllerImpl;
	private boolean isBookExists=false;
	List<Book> cmbdBooks=null;

	public BookController(BookService booksService, BookControllerImpl bookControllerImpl) {
		super();
		this.booksService = booksService;
		this.bookControllerImpl = bookControllerImpl;
	}
	
	@PostMapping
	public String addBook(@ModelAttribute Book book) {
		if (bookControllerImpl.isBookAlreadyExists(book,cmbdBooks)) {
			isBookExists = true;
			return "redirect:/books"; // Redirect with error if book exists
		}
        booksService.add(book);
        return "redirect:/books"; // reloads table after adding
    }
	
	@GetMapping
	public String showBooks(Model model) {
        model.addAttribute("books", booksService.get());
        if(isBookExists) {
        	model.addAttribute("errorMessage", "Book already exists!");
			isBookExists = false; // reset after showing the message
        }
        cmbdBooks = booksService.get();
        return "books";  // maps to books.jsp
    }
	
	// REST endpoint: Get single book
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        Book book = booksService.getById(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    // REST endpoint: Get books by Author ID
    @GetMapping("/author/{authorId}")
    @ResponseBody
    public ResponseEntity<List<Book>> getByAuthorId(@PathVariable Long authorId) {
        List<Book> books = booksService.getByAuthorId(authorId);
        if (books == null || books.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(books);
    }
    
  
	@PostMapping("/api")
	@ResponseBody
	public Book create(@RequestBody Book books) {
		return booksService.add(books);
	}

	@GetMapping("/api")
	@ResponseBody
	public List<Book> get() {
		return booksService.get();
	}
}