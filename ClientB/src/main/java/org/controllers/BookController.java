package org.controllers;


import org.codehaus.jackson.map.ObjectMapper;
import org.dtos.FilterDTO;
import org.models.Book;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BookController {

    public static final String REST_SERVICE_URI = "http://localhost:8080/";

    public static List<Book> getAllBooks() {
        System.out.println("------------Get all books----------");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Book>> rateResponse =
                restTemplate.exchange(REST_SERVICE_URI + "/book",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                        });
        List<Book> books = rateResponse.getBody();
		return books;
    }
    
    public static List<Book> getBooksFilter(FilterDTO filter) throws IOException {
        System.out.println("------------Get books by filter----------");
        RestTemplate restTemplate = new RestTemplate();
        
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(filter);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);
        ResponseEntity<List<Book>> rateResponse =
                restTemplate.exchange(REST_SERVICE_URI + "/book/filter",
                        HttpMethod.POST, entity, new ParameterizedTypeReference<List<Book>>() {
                        });
        List<Book> books = rateResponse.getBody();
		return books;
    }
}
