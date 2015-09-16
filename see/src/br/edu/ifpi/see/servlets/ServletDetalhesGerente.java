package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Usuario;

public class ServletDetalhesGerente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDetalhesGerente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Pega o parâmetro
		long id = Integer.parseInt(request.getParameter("id"));
		
		// Consulta o gerente
		UsuarioDAO dao = new UsuarioDAO();
		Usuario gerente = dao.pesquisar(id);
		
		// Coloca o gerente na requisição
		request.setAttribute("gerente", gerente);
		request.getRequestDispatcher("JSP/administrador/detalhesGerente.jsp").forward(request, response);
		
	}

}
