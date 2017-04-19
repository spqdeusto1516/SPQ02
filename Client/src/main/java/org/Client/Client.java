package org.Client;

import java.rmi.Naming;
import java.rmi.RemoteException;

import com.deusto.server.*;


public class Client {
	


	public void start(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			String URL = "//" + args[0] + ":" + args[1] + "/" + args[2];
			IServer server= (IServer) java.rmi.Naming.lookup(URL);
			server.sendMessage("Hello youtube friends");
	//		server.requestBook("LOTR");
	//		System.out.println("Book sent");
		} catch (Exception e) {
			System.err.println(" *# Error connecting to Server : " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
	
		try { 
			Client client = new Client();
			client.start(args);
			
		} catch (Exception e) {
			System.err.println("RMI Example exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
