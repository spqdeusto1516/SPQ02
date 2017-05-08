package org.test;

import org.models.*;
import org.ClientP.Application;
import org.apache.http.HttpEntity;
import org.dtos.FilterDTO;
import org.junit.Test;
import java.util.ArrayList;


public class AppTest{
  
    @Test
    public void getAllBooksFilter() throws Exception {
        FilterDTO filterDTO = new FilterDTO();

        filterDTO.setTitle("Test-book-1");
        filterDTO.setGenre("genre2");
        
        Application app = new Application();

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

