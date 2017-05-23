package org.test.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.controllers.BookController;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.dtos.FilterDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.models.Book;
import org.junit.Before;
import org.junit.Rule;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.junit.ContiPerfSuiteRunner;
import org.databene.contiperf.report.EmptyReportModule;


public class BookControllerTest {
	Logger logger = Logger.getLogger(BookControllerTest.class.getName());
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 1200, average = 250)
	public void getBooks(){
		List<Book> books1 = BookController.getAllBooks();
		for(int i=0; i<books1.size(); i++){
			logger.info(books1.get(i).toString());
		}
	}
	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 1200, average = 250)
	public void getBooksByFilterT() throws IOException{
		FilterDTO filter = new FilterDTO();
		filter.setTitle("hello");
		List<Book> books = BookController.getBooksFilter(filter);
		for(int i=0; i<books.size(); i++){
			logger.info(books.get(i).toString());
		}	
		
	}
	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 1200, average = 250)
	public void getBooksByFilterG() throws IOException{
		FilterDTO filter = new FilterDTO();
		filter.setGenre("a");;
		List<Book> books = BookController.getBooksFilter(filter);
		for(int i=0; i<books.size(); i++){
			logger.info(books.get(i).toString());
		}	
		
	}
	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 1200, average = 250)
	public void getBooksByFilterAN() throws IOException{
		FilterDTO filter = new FilterDTO();
		filter.setAuthorName("pedro");;
		List<Book> books = BookController.getBooksFilter(filter);
		for(int i=0; i<books.size(); i++){
			logger.info(books.get(i).toString());
		}	
		
	}
	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 1200, average = 250)
	public void getBooksByFilterAS() throws IOException{
		FilterDTO filter = new FilterDTO();
		filter.setAuthorSurname("string");;
		List<Book> books = BookController.getBooksFilter(filter);
		for(int i=0; i<books.size(); i++){
			logger.info(books.get(i).toString());
		}	
		
	}
	
	@Test
	@PerfTest(invocations = 3)
	@Required(max = 1200, average = 250)
	public void updateBook() throws IOException{
		List<Book> books = BookController.getAllBooks();
		Book book = books.get(1);
		book.setCount(10);
		book.setTitle("prueba");
		BookController.updateBook(book);
		
	}
}
