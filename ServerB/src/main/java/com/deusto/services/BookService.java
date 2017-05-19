package com.deusto.services;

import com.deusto.models.Book;
import com.deusto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bRepository;

    public Book insert(Book book) {
        return bRepository.insert(book);
    }

    public List<Book> findAll() {
        return bRepository.findAll();
    }

    public Book findById(String id) {
        return bRepository.findBookById(id);
    }

    public List<Book> findAllByAuthorFirstName(String firstName) {
        return bRepository.findAllByAuthorFirstName(firstName);
    }

    public List<Book> findByGenre(String genre) {
        return bRepository.findAllByGenre(genre);
    }

    public List<Book> findByTitle(String title) {
        return bRepository.findByTitle(title);
    }

    public List<Book> findByAuthorLastName(String lastName) {
        return bRepository.findAllByAuthorLastName(lastName);
    }

    public void update(Book registr) {
        bRepository.save(registr);
    }
}
