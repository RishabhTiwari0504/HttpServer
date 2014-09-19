package com.avalia.http.server.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import com.avalia.bank.Bank;
import com.avalia.bank.account.Account;
import com.avalia.http.server.util.Util;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class BalanceHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange t) throws IOException {

		Map<String, String> param = Util.getParam(t);
		Account acc = Bank.INSTANCE.checkBalance(Integer.parseInt(param
				.get("accNum")));

		String response = "Your Balance is :" + acc.getBalance();

		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();

	}

}
