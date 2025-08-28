package com.author.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.author.entities.Author;
import com.author.services.AuthorService;

@Controller
@RequestMapping("/author")
public class AuthorController {
	
	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	
	@PostMapping("/api")
	@ResponseBody
	public Author create(@RequestBody Author author) {
		return authorService.add(author);
	}
	
	@GetMapping("/api")
	@ResponseBody
	public List<Author> get() {
		return authorService.get();
	}
	
	@GetMapping("api/{id}")
	@ResponseBody
	public Author getById(@PathVariable Long id) {
		return authorService.getId(id);
	}
	
	//HTML FORM View Changes
	@GetMapping
	public String showAuthors(Model model) {
        model.addAttribute("authors", authorService.get());
        model.addAttribute("author", new Author()); // Needed for Thymeleaf form binding
        return "authors";  // maps to templates/authors.html
    }

    @PostMapping
    public String addAuthor(@ModelAttribute Author author) {
        authorService.add(author);
        return "redirect:/author"; // reload page
    }
}