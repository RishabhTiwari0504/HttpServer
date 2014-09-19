package com.avalia.http.server.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import com.avalia.bank.Bank;
import com.avalia.http.server.util.Util;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class WithdrawHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange t) throws IOException {

		Map<String, String> param = Util.getParam(t);
		Bank.INSTANCE.withdrawMoney(Integer.parseInt(param.get("accNum")),
				Integer.parseInt(param.get("amount")));

		String response = "Amount withdraw successfully. ";
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();

	}

}
