package org.test.controllers;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.controllers.LoginController;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.dtos.LoginDTO;
import org.junit.Rule;
import org.junit.Test;
import org.models.Token;

public class LoginControllerTest {
	Logger logger = Logger.getLogger(BookControllerTest.class.getName());
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 1200, average = 250)
	public void login() throws IOException{
		LoginDTO login = new LoginDTO();
		login.setEmail("ander.areizagab@opendeusto.es");
		login.setEncryptedPassword("1234");
		Token token = LoginController.login(login);
		logger.info(token.getToken());
	}
}
