package br.edu.ifpi.see.validation;

import java.util.HashMap;
import br.edu.ifpi.see.model.Usuario;

public class AutenticacaoValidation {
	
	private Usuario usuario;
	private HashMap<String, String> erros;
	
	public AutenticacaoValidation(Usuario usuario){
		this.usuario = usuario;
		this.erros = new HashMap<String,String>();
		this.validaLogin();
		this.validaSenha();
	}
	
	public void validaLogin(){
		boolean email = usuario.getEmail().matches("\\w+@+\\w+\\.\\w{2,3}\\.\\w{2,3}");
		if(email){
			erros.put("login", "ok");
		}else{
			email = usuario.getEmail().matches("\\w+@+\\w+\\.\\w{2,3}");
			if(email){
				erros.put("login", "ok");
			}else{
				erros.put("login", "E-mail inválido!");
			}
		}
	}
	
	public void validaSenha(){
		boolean senha = usuario.getSenha().matches("\\w{4}");
		if(senha){
			erros.put("senha", "ok");
		}else{
			erros.put("senha", "Senha inválida!");
		}
	}

}
