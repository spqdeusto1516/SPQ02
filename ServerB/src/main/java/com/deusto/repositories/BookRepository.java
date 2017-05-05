package com.deusto.repositories;

import com.deusto.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {
	Book findAllById(String id);
	List<Book> findByTitle(String title);
	List<Book> findAllByAuthorFirstName(String authorFirstName);
	List<Book> findAllByAuthorLastName(String authorLastName);
	List<Book> findAllByGenre(String genre);
}
