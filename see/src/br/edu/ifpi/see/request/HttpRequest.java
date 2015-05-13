package br.edu.ifpi.see.request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

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
		//String sensores = response.toString().replace("=", "&");
		String[] valores = response.toString().split("&");
		HashMap<String, String> parametros = new HashMap<String, String>();
		for (String par: valores){
			String[] partesparametro = par.split("=");
			parametros.put(partesparametro[0], partesparametro[1]);
		}
		
		in.close();
		
		Response r = new Response();
		r.setCode(responseCode);
		r.setPorta(parametros.get("porta"));
		r.setPresenca(parametros.get("presenca"));
		r.setLampadas(parametros.get("lampada"));
		r.setAr(parametros.get("ar"));
		
		return r;
	}

}
