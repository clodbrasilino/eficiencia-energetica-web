package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.autentication.Autenticador;
import br.edu.ifpi.see.autentication.Autenticavel;
import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Usuario;

public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAutenticacao() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Pega os parâmetros
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		// Consulta o usuário
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.pesquisar(email, senha);
		
		// Faz a autenticação do usuário
		Autenticador a = new Autenticador();
		a.autentica((Autenticavel) usuario, request, response);		
		
	}

}
