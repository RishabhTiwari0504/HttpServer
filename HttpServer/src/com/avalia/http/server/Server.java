package com.avalia.http.server;

import java.net.InetSocketAddress;

import com.avalia.http.server.handler.AddNewAccountHandler;
import com.avalia.http.server.handler.BalanceHandler;
import com.avalia.http.server.handler.CalculateInterestHandler;
import com.avalia.http.server.handler.DepositeHandler;
import com.avalia.http.server.handler.WithdrawHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {

	private static final int SOCKET = 8000;

	public static void main(String[] args) throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(SOCKET), 0);
		server.createContext("/account", new AddNewAccountHandler());
		server.createContext("/balance", new BalanceHandler());
		server.createContext("/interest", new CalculateInterestHandler());
		server.createContext("/deposite", new DepositeHandler());
		server.createContext("/withdraw", new WithdrawHandler());
		server.setExecutor(null); // creates a default executor
		server.start();
	}

}
