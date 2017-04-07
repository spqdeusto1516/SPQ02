package com.deusto.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
	void requestBook(String title) throws RemoteException;
	void sendMessage(String message) throws RemoteException;
}
