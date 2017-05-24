package org.test.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.controllers.RegistrController;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.dtos.RegistrDTO;
import org.junit.Rule;
import org.junit.Test;
import org.models.Address;
import org.models.User;

public class RegistrControllerTest {
	Logger logger = Logger.getLogger(BookControllerTest.class.getName());
	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 200000, average = 200000)
	public void registreStep1test() throws IOException{
		RegistrDTO registr = new RegistrDTO();
		registr.setFirstname("test");
		registr.setLastname("test");
		registr.setEmail("test@test.com");
		RegistrController.registrStep1(registr);
	}
	
	@Test
	public void registreStep1() throws IOException{
		RegistrDTO registr = new RegistrDTO();
		registr.setFirstname("Ander");
		registr.setLastname("Areizaga");
		registr.setEmail("ander.areizagab@opendeusto.es");
		RegistrController.registrStep1(registr);
	}
	@Test
	public void registreStep2() throws IOException, InterruptedException{
		Thread.sleep(20000);
		Address address = new Address();
		address.setStreet("R");
		address.setHouseNumber(123);
		address.setCity("b");
		address.setCountry("b");
		address.setPostalCode("123");
		address.setApartamentNumber(1);
		User user = new User();
		user.setEmail("ander.areizagab@opendeusto.es");
		user.setBirthDate(1234123);
		user.setFirstname("Ander");
		user.setLastname("Areizaga");
		user.setAddress(address);
		RegistrController.registrStep2(user);
	}
	
}
