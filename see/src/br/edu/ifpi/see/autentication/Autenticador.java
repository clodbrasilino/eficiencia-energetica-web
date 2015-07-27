package br.edu.ifpi.see.autentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.model.Usuario;

public class Autenticador {
	
	public void autentica(Usuario u, HttpServletRequest request, HttpServletResponse response){
		
		try{
			if(u != null){
				request.getSession().setAttribute("usuario", u);
				response.sendRedirect(u.autentica());
			}else{
				request.getSession().setAttribute("mensagem","E-mail e/ou Senha inválido(s)!");
				response.sendRedirect("/see/");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
