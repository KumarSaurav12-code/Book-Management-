package com.author.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.author.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
}