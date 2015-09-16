package br.edu.ifpi.see.model;

import java.util.HashMap;

import javax.persistence.Entity;

import br.edu.ifpi.see.autentication.Autenticavel;
import br.edu.ifpi.see.validation.GerenteValidation;
import br.edu.ifpi.see.validation.Validavel;

@Entity
public class Gerente extends Usuario implements Autenticavel, Validavel {
	
	private boolean ativo;
	
	public Gerente(){
		super();
	}
	
	public Gerente(String nome, String endereco, String email, String telefone, String senha, String confirmacaoSenha, boolean ativo){
		super(nome, endereco, email, telefone, confirmacaoSenha, senha);
		this.ativo = ativo;
	}
	
	@Override
	public String autentica() {
		return "/see/JSP/gerente/gerente.jsp";
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public String getAtivo(){
		if(this.ativo){
			return "Sim";
		}else{
			return "Não";
		}
	}
	
	public String isChecked(){
		if(this.ativo){
			return "hecked";
		}else{
			return "";
		}
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public HashMap<String, String> valida() {
		
		GerenteValidation uv = new GerenteValidation(this);
		return uv.getErros();
		
	}
	
}
