package org.controllers;


import org.models.Bookk;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class BookController {

    public static final String REST_SERVICE_URI = "http://localhost:8080/";

    public static void getAllBooks() {
        System.out.println("------------Get all books----------");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Bookk>> rateResponse =
                restTemplate.exchange(REST_SERVICE_URI + "/book",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Bookk>>() {
                        });
        List<Bookk> bookks = rateResponse.getBody();

        System.out.println(bookks.get(2).getTitle());
    }
}
