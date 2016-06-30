package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCadastroSala
 */
public class ServletCadastroSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastroSala() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String botao = request.getParameter("botao");
		
		switch(botao){
		case "Salvar":
			request.getRequestDispatcher("ServletSalvarSala").forward(request, response);
			break;
		case "Adicionar":
			request.getRequestDispatcher("ServletMicroControlador").forward(request, response);
			break;
		}
				
	}

}
