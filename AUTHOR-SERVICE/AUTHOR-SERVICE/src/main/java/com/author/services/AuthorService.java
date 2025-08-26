package com.author.services;

import java.util.List;
import com.author.entities.Author;


public interface AuthorService {
	Author add(Author qauthor);
	
	List<Author> get();
	
	Author getId(Long id);
}