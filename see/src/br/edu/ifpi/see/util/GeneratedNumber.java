package br.edu.ifpi.see.util;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifpi.see.dao.MicroControladorDAO;
import br.edu.ifpi.see.dao.SalaDAO;
import br.edu.ifpi.see.dao.UsuarioDAO;

public class GeneratedNumber {
	
	public String geraNumeroAdministrador(){
		String numero = StringUtils.leftPad("1", 3, "0");
		return "A"+numero;
	}
	
	public String geraNumeroGerente(){
		UsuarioDAO dao = new UsuarioDAO();
		String numero = StringUtils.leftPad(dao.getUltimoId()+"", 3, "0");
		return "G"+numero;
	}
	
	public String geraNumeroSala(){
		SalaDAO dao = new SalaDAO();
		String numero = StringUtils.leftPad(dao.getUltimoId()+"", 3, "0");
		return "S"+numero;
	}
	
	public String geraNumeroMC(){
		MicroControladorDAO dao = new MicroControladorDAO();
		String numero = StringUtils.leftPad(dao.getUltimoId()+"", 3, "0");
		return "MC"+numero;
	}
	
	public String converteNumeroAdministrador(){
		String numero = StringUtils.leftPad("1", 3, "0");
		return "A"+numero;
	}
	
	public String converteNumeroGerente(long id){
		String numero = StringUtils.leftPad(id+"", 3, "0");
		return "G"+numero;
	}
	
	public String converteNumeroSala(long id){
		String numero = StringUtils.leftPad(id+"", 3, "0");
		return "S"+numero;
	}
	
	public String converteNumeroMC(long id){
		String numero = StringUtils.leftPad(id+"", 3, "0");
		return "MC"+numero;
	}

}
