package com.books.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.books.services.BookService;
import com.books.entities.Book;
import com.books.repositories.BooksRepository;

@Service
public class BookServiceImpl implements BookService {

	private BooksRepository booksRepository;
	
	public BookServiceImpl(BooksRepository booksRepository) {
		super();
		this.booksRepository = booksRepository;
	}

	@Override
	public Book add(Book book) {
		return booksRepository.save(book);
	}

	@Override
	public List<Book> get() {
		return booksRepository.findAll();
	}

	@Override
	public Book getById(Long id) {
		return booksRepository.findById(id).orElseThrow(() -> new RuntimeException(" Book not Found "));
	}

	@Override
	public List<Book> getByAuthorId(Long authorId) {
		return booksRepository.findByAuthorId(authorId);
	}
	
}