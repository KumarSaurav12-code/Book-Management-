package com.author.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.author.entities.Book;


//@FeignClient(url = "http://localhost:8082",value = "Question-Client")
@FeignClient(name = "BOOKS-SERVICE")
public interface BookClient {
	
	@GetMapping("/question/quiz/{quizId}")
	List<Book> getByIBookId(@PathVariable Long bookId);
}