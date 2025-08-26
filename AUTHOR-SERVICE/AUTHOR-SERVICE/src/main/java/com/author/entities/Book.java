package com.author.entities;

public class Book {
	
	private Long bookId;
	private String bookTitle;
	private Long genre;
	private Long authorId;
	
	public Book() {
		super();
	}

	public Book(Long bookId, String bookTitle, Long genre, Long authorId) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.genre = genre;
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

	public Long getGenre() {
		return genre;
	}

	public void setGenre(Long genre) {
		this.genre = genre;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	
	
		
}