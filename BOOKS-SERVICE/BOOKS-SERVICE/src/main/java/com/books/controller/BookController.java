package com.books.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.services.BookService;
import com.books.entities.*;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private BookService booksService;

	public BookController(BookService booksService) {
		super();
		this.booksService = booksService;
	}
	
	@PostMapping
	public Book create(@RequestBody Book books) {
		return booksService.add(books);
	}
	
	@GetMapping
	public List<Book> get() {
		return booksService.get();
	}
	
	@GetMapping("/{id}")
	public Book getById(@PathVariable Long id) {
		return booksService.getById(id);
	}
	
	@GetMapping("/author/{authorId}")
	public List<Book> getByIBookId(@PathVariable Long authorId) {
		return booksService.getByAuthorId(authorId);
	}
}