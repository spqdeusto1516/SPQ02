package com.deusto.controllers;

import com.deusto.builders.BookBuilder;
import com.deusto.dtos.BookDTO;
import com.deusto.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /* pentru mine ca sa pot introduce carti */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> createBook(@RequestBody BookDTO bookDTO) {

        return new ResponseEntity(bookService.insert(BookBuilder.get(bookDTO)), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getBookById(@PathVariable String id) {
        return new ResponseEntity(bookService.findById(id), OK);
    }

//    /* trial pentru parametri de filtrare */
//    @GetMapping()
//    public HttpEntity<?> getAllBooksFilter(@RequestParam(value = "title") String title) {
//        return new ResponseEntity(bookService.findByTitle(title), OK);
//    }
//
//    @GetMapping()
//    public HttpEntity<?> getByParams(@RequestBody Map<String,String> requestParams, String title) {
////        String title = requestParams.get("title");
//        String genre = requestParams.get("genre");
//        return new ResponseEntity(bookService.findAllByTitleAndGenre(requestParams.get(title), genre), OK);
//    }
}
