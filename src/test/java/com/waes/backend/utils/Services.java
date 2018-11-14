package com.waes.backend.utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;


public class Services {
	
	private final String AGENT = "Mozilla/5.0";
	
	public String httpRequestResponse(String type, String url) throws Exception {
		
		String response = null;
		
		if(type.equals("get")) {
			response = sendGet(url);
		}
		
		return response;
	}
	
	public String getResponseData(String response, String fieldName) throws Exception {
		
		JSONObject jsonObj = new JSONObject(response);
		String data = jsonObj.getString(fieldName);
		return data;
	}
	
	public String sendGet(String url) throws Exception {

		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", AGENT);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}
	

}
