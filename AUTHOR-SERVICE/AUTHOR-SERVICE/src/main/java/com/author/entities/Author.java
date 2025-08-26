package com.author.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String country;
	transient private List<Book> Books;
	
	public Author(Long id, String name, String country, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		Books = books;
	}
	
	public Author() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<Book> getBooks() {
		return Books;
	}
	public void setBooks(List<Book> books) {
		Books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	
	
}