package com.books.services;

import java.util.List;
import com.books.entities.Book;


public interface BookService {
	Book add(Book book);
	
	List<Book> get();
	
	Book getById(Long id);
	
	List<Book> getByQuizId(Long quizId);
}