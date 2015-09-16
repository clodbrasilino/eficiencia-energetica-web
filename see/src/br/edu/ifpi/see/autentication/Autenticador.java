package br.edu.ifpi.see.autentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Autenticador {
	
	public void autentica(Autenticavel a, HttpServletRequest request, HttpServletResponse response){
		
		try{
			if(a != null){
				request.getSession().setAttribute("usuario", a);
				response.sendRedirect(a.autentica());
			}else{
				request.getSession().setAttribute("mensagem","E-mail e/ou Senha inválido(s)!");
				response.sendRedirect("/see/");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
