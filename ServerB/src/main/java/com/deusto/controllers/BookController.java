package com.deusto.controllers;

import com.deusto.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getBooks() {
        return new ResponseEntity(bookService.findAll(), HttpStatus.OK);
    }

}
