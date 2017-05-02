package com.deusto.repository;

import com.deusto.model.Book;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,String>{
	List<Book> findByTitle(String title);
}
