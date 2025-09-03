package com.books.controller.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.books.entities.Book;

@Service
public class BookControllerImpl {

	public boolean isBookAlreadyExists(Book book, List<Book> cmbdBooks) {
		if(cmbdBooks != null) {
			for(Book eachBook : cmbdBooks) {
				if(eachBook.getAuthorId() == book.getAuthorId() && 
						eachBook.getBookTitle().equalsIgnoreCase(book.getBookTitle())) {
					return true;
				}
			}
		}
		return false;
	}
	
}