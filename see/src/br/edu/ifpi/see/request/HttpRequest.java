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
		
		// Separação dos números
		String sensores = response.toString().replace("=", "&");
		String[] valores = sensores.split("&");
		
		in.close();
		
		Response r = new Response();
		r.setCode(responseCode);
		r.setPorta(valores[1]);
		r.setPresenca(valores[3]);
		r.setLampadas(valores[5]);
		r.setAr(valores[7]);
		
		return r;
	}

}
