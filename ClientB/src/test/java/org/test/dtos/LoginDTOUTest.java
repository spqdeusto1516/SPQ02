package org.test.dtos;


import org.junit.Rule;
import org.junit.Test;
import org.test.controllers.BookControllerTest;

import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.dtos.LoginDTO;

public class LoginDTOUTest {
	Logger logger = Logger.getLogger(BookControllerTest.class.getName());
	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 120, average = 50)
    public void validLoginDTO() {
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setEmail("some.email@mail.com");
        loginDTO.setEncryptedPassword("some encrypted password");

        logger.info(loginDTO.getEmail());
        logger.info(loginDTO.getEncryptedPassword());
    }

}
