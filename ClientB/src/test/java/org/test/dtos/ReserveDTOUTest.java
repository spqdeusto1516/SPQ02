package org.test.dtos;

import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.dtos.ReserveDTO;
import org.junit.Rule;
import org.junit.Test;
import org.test.controllers.BookControllerTest;

public class ReserveDTOUTest {
	Logger logger = Logger.getLogger(BookControllerTest.class.getName());
	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 120, average = 50)
	public void reserve(){
		ReserveDTO reserve = new ReserveDTO();
		reserve.setBookId("12341243");
		logger.info(reserve.getBookId());
	}
}
