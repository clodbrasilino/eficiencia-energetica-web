package br.edu.ifpi.see.request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
	
	public Response sendGet(String ip) throws Exception{
		// Request
		URL url = new URL("http://" + ip);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		// Response
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while((inputLine = in.readLine()) != null){
			response.append(inputLine);
		}
		
		String[] sensores = response.toString().split("&");
		System.out.println("Início");
		for (int i = 0; i < sensores.length; i++) {
			System.out.println(sensores[i]);
		}
		System.out.println("Fim\n");
		in.close();
		
		Response r = new Response();
		r.setCode(responseCode);
		r.setPorta(sensores[0]);
		r.setPresenca(sensores[1]);
		r.setLampadas(sensores[2]);
		r.setAr(sensores[3]);
		return r;
	}

}
