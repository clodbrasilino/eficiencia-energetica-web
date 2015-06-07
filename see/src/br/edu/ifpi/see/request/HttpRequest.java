package br.edu.ifpi.see.request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import br.edu.ifpi.see.model.MicroControlador;

public class HttpRequest {
	
	public Response sendGet(MicroControlador mc) throws Exception{
		// Request
		URL url = new URL("http://" + mc.getIp() + ":8080/emulador-see");
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
			//parametros.put(partesparametro[0], partesparametro[1]);
			parametros.put(partesparametro[0], this.verificaResposta(mc, partesparametro[0], partesparametro[1]));
		}
		
		in.close();
		
		Response r = new Response();
		r.setCode(responseCode);
		r.setPorta(parametros.get("porta"));
		r.setPresenca(parametros.get("presenca"));
		r.setLampadas(parametros.get("luz"));
		r.setAr(parametros.get("ar"));
		
		System.out.println("Micro controlador: "+mc.getIp());
		System.out.println("Porta: "+r.getPorta());
		System.out.println("Presença: "+r.getPresenca());
		System.out.println("Lâmpadas: "+r.getLampadas());
		System.out.println("Ar: "+r.getAr()+"\n");
		return r;
	}
	
	private String verificaResposta(MicroControlador mc, String sensor, String valor){
		
		if(valor.equals("-1")){
			if(mc.temSensor(sensor)){
				return valor;
			}else{
				return "0";
			}
		}else{
			return valor;
		}
		
		/*if(valor == "0"){
			return "0";
		}else if(valor == "1"){
			return "1";
		}else{
			if(mc.temSensor(sensor)){
				return "-1";
			}else{
				return "0";
			}
		}*
		
		/*if(valor == "0" || valor == "1"){
			return valor;
		}else{
			if(mc.temSensor(sensor)){
				return valor;
			}else{
				return "0";
			}
		}*/
	}

}
