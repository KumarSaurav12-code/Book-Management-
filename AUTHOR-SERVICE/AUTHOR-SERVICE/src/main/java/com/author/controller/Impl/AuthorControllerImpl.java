package com.author.controller.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.author.entities.Author;

@Service
public class AuthorControllerImpl {

	public boolean isAuthorAlreadyExists(Author author, List<Author> authorList) {
		if(authorList != null) {
			for(Author eachAuthor : authorList) {
				if(eachAuthor.getName().equalsIgnoreCase(author.getName())) {
					return true;
				}
			}
		}
		return false;
	}
	
}