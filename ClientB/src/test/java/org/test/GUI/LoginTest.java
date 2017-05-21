package org.test.GUI;

import org.GUI.Login;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

public class LoginTest {
	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 2)
	public void loginGUI() throws InterruptedException{
		Login login = new Login();
		Thread.sleep(2000);
	}
}
