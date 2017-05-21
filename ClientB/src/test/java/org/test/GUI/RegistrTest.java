package org.test.GUI;

import org.GUI.Login;
import org.GUI.Register;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

public class RegistrTest {
	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 2)
	public void registr1GUI() throws InterruptedException{
		Register register = new Register();
		Thread.sleep(2000);
	}
}
