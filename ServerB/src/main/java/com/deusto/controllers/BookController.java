package com.deusto.controllers;

import com.deusto.builders.BookBuilder;
import com.deusto.dtos.BookDTO;
import com.deusto.dtos.FilterDTO;
import com.deusto.models.Book;
import com.deusto.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

/*!
 * Controller for mapping routes related to book.
 * It is implements logic for returning all the books via GET method,
 * create a book via POST, retrieve by ID using GET mapping as well as
 * filtering by specific parameter using POST method.
 */

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * Retreives all the books.
     * @return ResponseEntity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getAllBooks() {
        return new ResponseEntity(bookService.findAll(), OK);
    }

    /**
     * Creates a new book
     * @param bookDTO BookDTO
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> createBook(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity(bookService.insert(BookBuilder.get(bookDTO)), HttpStatus.OK);
    }
    
    /**
     * Creates a new book
     * @param Book book
     */
    @PostMapping(path = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> updateBook(@RequestBody Book book) {
        return new ResponseEntity(bookService.update(book), HttpStatus.OK);
    }


    /**
     * Get book by id
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getBookById(@PathVariable String id) {
        return new ResponseEntity(bookService.findById(id), OK);
    }

    /**
     * Get books depending on the sent parameter
     * @param filterDTO
     * @return
     */
    @PostMapping(path = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getAllBooksFilter1(@RequestBody FilterDTO filterDTO) {
        Set set = new HashSet();
        Long nullValue = null;
        List<Book> bookList = new ArrayList<>(); // set rather than list
        if (filterDTO.getGenre() != null) {
            set.addAll(bookService.findByGenre(filterDTO.getGenre()));
        }
        if(filterDTO.getTitle() != null) {
            set.addAll(bookService.findByTitle(filterDTO.getTitle()));
        }
        
        if (filterDTO.getAuthorName() != null) {
            set.addAll(bookService.findAllByAuthorFirstName(filterDTO.getAuthorName()));
        }
        
        if (filterDTO.getAuthorSurname() != null) {
            set.addAll(bookService.findByAuthorLastName(filterDTO.getAuthorSurname()));
        }
        
        bookList.addAll(set);
        return new ResponseEntity<>(bookList, OK);
    }
}