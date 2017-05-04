package com.deusto.repositories;

import com.deusto.models.Book;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,String>{
	List<Book> findByTitle(String title);
}
