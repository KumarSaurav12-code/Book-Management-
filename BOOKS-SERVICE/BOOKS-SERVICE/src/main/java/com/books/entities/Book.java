package com.books.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	private String bookTitle;
	private String genre;
	private boolean isAvailable;
	private Long authorId;
	
	public Book() {
		super();
	}

	public Book(Long bookId, String bookTitle, String genre, boolean isAvailable, Long authorId) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.genre = genre;
		this.isAvailable = isAvailable;
		this.authorId = authorId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", genre=" + genre + ", isAvailable="
				+ isAvailable + ", authorId=" + authorId + "]";
	}
	
	
}