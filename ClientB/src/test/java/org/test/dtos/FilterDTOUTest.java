package org.test.dtos;

import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.dtos.FilterDTO;
import org.junit.Rule;
import org.junit.Test;
import org.test.controllers.BookControllerTest;

public class FilterDTOUTest {
	Logger logger = Logger.getLogger(BookControllerTest.class.getName());
	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 120, average = 50)
    public void validFilterDTOT() {
		FilterDTO filter = new FilterDTO();
		filter.setTitle("hello");
		logger.info(filter.getTitle());
	}
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 120, average = 50)
    public void validFilterDTOG() {
		FilterDTO filter = new FilterDTO();
		filter.setGenre("a");
		logger.info(filter.getGenre());
	}
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 120, average = 50)
    public void validFilterDTOAN() {
		FilterDTO filter = new FilterDTO();
		filter.setAuthorName("pedro");;
		logger.info(filter.getAuthorName());
	}
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 120, average = 50)
    public void validFilterDTOAS() {
		FilterDTO filter = new FilterDTO();
		filter.setAuthorSurname("fed");;
		logger.info(filter.getAuthorSurname());
	}
}
