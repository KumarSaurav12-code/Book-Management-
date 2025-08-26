package com.books.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.books.entities.Book;

public interface BooksRepository extends JpaRepository<Book, Long>{
	List<Book> findByAuthorId(Long authorId);
}