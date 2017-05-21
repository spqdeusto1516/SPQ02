package org.test.GUI;

import java.io.IOException;

import org.GUI.Booking;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

public class BookingTest {
	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 2)
	public void bookingTest() throws IOException, InterruptedException{
		Booking booking = new Booking();
		Thread.sleep(2000);
	}
}
