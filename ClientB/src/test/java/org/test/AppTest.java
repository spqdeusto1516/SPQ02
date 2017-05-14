package org.test;

import org.models.*;
import org.ClientP.Application;
import org.apache.http.HttpEntity;
import org.dtos.FilterDTO;
import org.junit.Test;

import java.util.ArrayList;

//I have to execute the server separetly
public class AppTest{
	
    @Test
    public void getAllBooksFilter() throws Exception {
        FilterDTO filterDTO = new FilterDTO();

        filterDTO.setTitle("hello");
        
        Application app = new Application();
        FilterDTO filter = new FilterDTO();
		filter.setTitle("hello");

		HttpEntity entity2 = app.getBooksFilter(filterDTO);
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

