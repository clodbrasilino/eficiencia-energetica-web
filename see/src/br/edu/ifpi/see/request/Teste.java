package br.edu.ifpi.see.request;

import java.util.ArrayList;

import br.edu.ifpi.see.model.MicroControlador;

public class Teste {

	public static void main(String[] args) {
		ArrayList<MicroControlador> lista = new ArrayList<MicroControlador>();
		
		MicroControlador mc = new MicroControlador();
		mc.setIp("127.0.0.1:8080/see/control");
		
		lista.add(mc);
		
		GeneratedStatus s = new GeneratedStatus();
		System.out.println("Status da sala: " + s.getStatus(lista));
		
	}

}
