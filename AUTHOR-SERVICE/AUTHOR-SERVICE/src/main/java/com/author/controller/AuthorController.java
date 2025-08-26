package com.author.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.author.entities.Author;
import com.author.services.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	
	@PostMapping
	public Author create(@RequestBody Author author) {
		return authorService.add(author);
	}
	
	@GetMapping
	public List<Author> get() {
		return authorService.get();
	}
	
	@GetMapping("/{id}")
	public Author getById(@PathVariable Long id) {
		return authorService.getId(id);
	}
}