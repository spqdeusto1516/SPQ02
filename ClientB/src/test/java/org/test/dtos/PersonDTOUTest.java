package org.test.dtos;


import org.junit.Rule;
import org.junit.Test;
import org.test.controllers.BookControllerTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.dtos.AddressDTO;
import org.dtos.PersonDTO;

public class PersonDTOUTest {
	Logger logger = Logger.getLogger(BookControllerTest.class.getName());
	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 120, average = 50)
    public void validPersonDTO() {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setBirthDate(0L);

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCountry("Moldova");
        personDTO.setAddress(addressDTO);

        personDTO.setEmail("email@example.com");
        personDTO.setCountryCode("1234");
        personDTO.setPassword("password");
        personDTO.setPhone(123456789);

        assertThat(personDTO.getAddress().getCountry(), is("Moldova"));
        assertThat(personDTO.getEmail(), is("email@example.com"));
        assertThat(personDTO.getCountryCode(), is("1234"));
        assertThat(personDTO.getPassword(), is("password"));
        assertThat(personDTO.getPhone(), is(123456789));
        
        logger.info(personDTO.getEmail());
    }
}
