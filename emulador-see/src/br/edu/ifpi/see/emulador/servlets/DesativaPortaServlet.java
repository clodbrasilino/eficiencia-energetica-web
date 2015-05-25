package br.edu.ifpi.see.emulador.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.emulador.model.Estado;
import br.edu.ifpi.see.emulador.model.EstadoEmulador;

/**
 * Servlet implementation class DesativaPortaServlet
 */
@WebServlet("/desativaPorta")
public class DesativaPortaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		((EstadoEmulador)getServletContext().getAttribute("estadoAtual")).setPorta(Estado.DESATIVADO);
		request.getRequestDispatcher("/configurar.jsp").forward(request, response);
	}

}
