package org.test.GUI;

import org.GUI.Login;
import org.GUI.Register2;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

public class Registr2Test {
	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 2)
	public void registr2GUI() throws InterruptedException{
		Register2 register2 = new Register2();
		Thread.sleep(2000);
	}
}
