package org.test;

import org.models.*;
import org.springframework.test.web.servlet.MvcResult;
import org.test.common.AbstractIt;
import org.ClientP.Application;
import org.apache.http.HttpEntity;
import org.codehaus.jackson.map.ObjectMapper;
import org.dtos.FilterDTO;
import org.junit.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

//I have to execute the server separetly
public class AppTest{
	
    @Test
    public void getAllBooksFilter() throws Exception {
        FilterDTO filterDTO = new FilterDTO();

        filterDTO.setTitle("hello");
        
        Application app = new Application();
        ObjectMapper objectMapper = new ObjectMapper();

		FilterDTO filter = new FilterDTO();
		filter.setTitle("hello");

		HttpEntity entity2 = app.getBooksFilter("http://localhost:8080/book/filter", filterDTO);
		app.getBooks(entity2);

    }

    @Test
    public void findAll() throws Exception {
    	Application app = new Application();
		HttpEntity entity = app.startConnectionGet("http://localhost:8080/book");
		ArrayList<Book> books = app.getBooks(entity);
		System.out.println(books.get(0).getTags().get(0));
		System.out.println(books.get(0).getTags().get(1));
    }
}

