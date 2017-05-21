package org.test.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.controllers.BookController;
import org.controllers.LoginController;
import org.controllers.ReserveController;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.dtos.LoginDTO;
import org.dtos.ReserveDTO;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.models.Book;
import org.models.Token;

public class ReserveControllerTest {
	Logger logger = Logger.getLogger(BookControllerTest.class.getName());
	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 1200, average = 250)
	public void reserve() throws IOException{
		LoginDTO login =  new LoginDTO();
		login.setEmail("ander.areizagab@opendeusto.es");
		login.setEncryptedPassword("1234");
		Token token = LoginController.login(login);
		
		List<Book> books = BookController.getAllBooks();
		
		ReserveDTO reserv = new ReserveDTO();
		reserv.setBookId(books.get(0).getId());
		ReserveController.create(reserv, token);
		logger.info(reserv.getBookId());
	}
}
