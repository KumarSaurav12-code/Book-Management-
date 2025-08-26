package com.author.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.author.services.AuthorService;
import com.author.entities.Author;
import com.author.repositories.AuthorRepository;
import com.author.services.BookClient;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private AuthorRepository authorRepository;
	private BookClient bookClient;
	
	public AuthorServiceImpl(AuthorRepository authorRepository, BookClient bookClient) {
		super();
		this.authorRepository = authorRepository;
		this.bookClient = bookClient;
	}

	public Author add(Author author) {
		return authorRepository.save(author);
	}

	public List<Author> get() {
		List<Author> authorzes = authorRepository.findAll();
		
		List<Author> newAuthorList = authorzes.stream().map(author -> {
			author.setBooks(bookClient.getByIBookId(author.getId()));
			return author;
		}).collect(Collectors.toList());
		return newAuthorList;
	}

	public Author getId(Long id) {
		Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not Found!!!"));
		author.setBooks(bookClient.getByIBookId(author.getId()));
		return author;
	}
	
}