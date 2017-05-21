package org.test.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.controllers.BookController;
import org.junit.Test;
import org.models.Book;

public class BookControllerTest {
	Logger logger = Logger.getLogger(BookControllerTest.class.getName());
	@Test
	public void getBooks(){
		List<Book> books = BookController.getAllBooks();
		for(int i=0; i<books.size(); i++){
			logger.info(books.get(i).toString());
		}
	}
}
