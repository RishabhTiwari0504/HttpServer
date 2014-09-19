package com.avalia.http.server.util;

import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

public class Util {

	public static Map<String, String> getParam(HttpExchange t) {

		Map<String, String> queryParams = new HashMap<>();
		String query = t.getRequestURI().getQuery();
		if (query != null) {
			String[] split = query.split("&");
			for (String param : split) {
				String[] params = param.split("=");
				queryParams.put(params[0], params[1]);
			}
		}

		return queryParams;

	}
}
