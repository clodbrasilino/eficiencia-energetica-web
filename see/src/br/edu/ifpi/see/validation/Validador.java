package br.edu.ifpi.see.validation;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Validador {
	
	public boolean valida(HttpServletRequest request, Validavel obj){
		
		HashMap<String, String> erros = obj.valida();
		
		for(Map.Entry<String, String> e : erros.entrySet()){
			if(e.getValue() != ""){
				request.getSession().setAttribute("erros", erros);
				return false;
			}
		}
		return true;
	}

}
