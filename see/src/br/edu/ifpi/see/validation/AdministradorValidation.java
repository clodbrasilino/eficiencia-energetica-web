package br.edu.ifpi.see.validation;

import java.util.HashMap;

import br.edu.ifpi.see.model.Usuario;

public class AdministradorValidation {
	
	private Usuario usuario;
	private HashMap<String, String> erros;
	
	public AdministradorValidation(Usuario usuario){
		this.usuario = usuario;
		this.erros = new HashMap<String,String>();
		this.validaNome();
		this.validaEmail();
		this.validaTelefone();
	}
	
	public void validaNome(){
		boolean nome = usuario.getNome().matches("\\w+.*");
		if(!nome){
			erros.put("nome", "Nome inv�lido!");
		}else{
			erros.put("nome", "");
		}
	}
	
	public void validaEmail(){
		boolean email = usuario.getEmail().matches("\\w+@+\\w+\\.\\w{2,3}\\.\\w{2,3}");
		if(!email){
			email = usuario.getEmail().matches("\\w+@+\\w+\\.\\w{2,3}");
			if(!email){
				erros.put("email", "E-mail inv�lido!");
			}else{
				erros.put("email", "");
			}
		}else{
			erros.put("email", "");
		}
	}
	
	public void validaTelefone(){
		boolean telefone = usuario.getTelefone().matches("\\([0-9]{2}\\)[0-9]{5}[0-9]{4}");
		if(!telefone){
			telefone = usuario.getTelefone().matches("\\([0-9]{2}\\)[0-9]{4}[0-9]{4}");
			if(!telefone){
				erros.put("telefone", "Telefone inv�lido!");
			}else{
				erros.put("telefone", "");
			}
		}else{
			erros.put("telefone", "");
		}
	}
	
	public HashMap<String, String> getErros(){
		return erros;
	}

}
