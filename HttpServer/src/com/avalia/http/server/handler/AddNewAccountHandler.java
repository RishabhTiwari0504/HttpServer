package com.avalia.http.server.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class AddNewAccountHandler implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		Map<String, String> queryParams = new HashMap<>();
		String query = t.getRequestURI().getQuery();
		if (query != null) {
			String[] split = query.split("&");
			for (String param : split) {
				String[] params = param.split("=");
				queryParams.put(params[0], params[1]);
			}
		}

		String response = "This is the response";
		
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
}