package com.deusto.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.deusto.model.Book;
import com.deusto.repository.BookRepository;
import com.deusto.server.IServer;


public class Server extends UnicastRemoteObject implements IServer{
	
	BookRepository repository;
	private static final long serialVersionUID = 1L;

	public Server() throws RemoteException {
		super();
	}

	@Override
	public void requestBook(String title) throws RemoteException {
		for (Book books : repository.findByTitle(title)) {
			System.out.println(books.getId());
		}
	}
	@Override
	public void sendMessage(String message) throws RemoteException {
		System.out.println(message);
		
	}
	
	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		

		try {
			IServer objServer = new Server();
			Naming.rebind(name, objServer);
			System.out.println("Server '" + name + "' active and waiting...");
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			@SuppressWarnings("unused")
			String line  = stdin.readLine();
		} catch (Exception e) {
			System.err.println("Server exception: " + e.getMessage());
			e.printStackTrace();
		}
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException ie) {
//			ie.printStackTrace();
//		}
	}

	

}
