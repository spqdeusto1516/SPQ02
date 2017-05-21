package org.test.dtos;

import org.junit.Test;
import org.test.controllers.BookControllerTest;

import org.apache.log4j.Logger;
import org.dtos.RegistrDTO;

public class RegistrDTOUTest {
	Logger logger = Logger.getLogger(BookControllerTest.class.getName());
    @Test
    public void validRegistrDTO() {
        RegistrDTO registrDTO = new RegistrDTO();

        registrDTO.setFirstname("firstname");
        registrDTO.setLastname("lastname");
        registrDTO.setEmail("some.email@mail.com");
        logger.info(registrDTO.getEmail());
        
    }

}
