package br.edu.ifpi.see.model;

import java.util.HashMap;

import javax.persistence.Entity;

import br.edu.ifpi.see.autentication.Autenticavel;
import br.edu.ifpi.see.validation.AdministradorValidation;
import br.edu.ifpi.see.validation.Validavel;

@Entity
public class Administrador extends Usuario implements Autenticavel, Validavel {

	@Override
	public String autentica() {
		return "/see/JSP/administrador/administrador.jsp";
	}

	@Override
	public HashMap<String, String> valida() {
		
		AdministradorValidation uv = new AdministradorValidation(this);
		return uv.getErros();
		
	}
	
}
