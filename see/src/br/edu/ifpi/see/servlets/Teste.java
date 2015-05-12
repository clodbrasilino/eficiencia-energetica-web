package br.edu.ifpi.see.servlets;

import java.util.HashMap;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "porta=1&presenca=0&lampada=1&ar=-1";
		url = url.replace("=", "&");
		String[] sensores = url.split("&");
		
		for (int i = 0; i < sensores.length; i++) {
			System.out.println(sensores[i]);
		}
		
		
		
		
	}

}
