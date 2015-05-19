package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpi.see.model.Usuario;

/**
 * Servlet implementation class ServletIndentificaUsuario
 */
public class ServletIndentificaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIndentificaUsuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 	Função do Servlet: Receber usuário, identificá-lo (Administrador ou Gerente), e redirecionar para a pagina correspondente.
	 * 	
	 * 	Fluxo:
	 * 		- Recebe usuário
	 * 		- Indentifica-o (Administrador ou Gerente)
	 * 		- Redireciona para a página correspondente ao tipo do usuário.
	 * 	
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletIndentificaUsuario");
		
		/* Reculperar sessão: */
		HttpSession s = request.getSession();
		
		/* Reculperar usuário: */
		Usuario u = (Usuario) s.getAttribute("usuario");
		
		
		if(u.getTipo() == 1){
			/*	Caso o usuário seja Administrador:  */
			//request.getRequestDispatcher("JSP/ADMINISTRADOR/administrador.jsp").forward(request, response);
			response.sendRedirect("/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/administrador.jsp");
			return;
		}
		else if(u.getTipo() == 2){
			/*	Caso o usuário seja Gerente:  */
			//request.getRequestDispatcher("/projeto2/JSP/GERENTE/gerente.jsp").forward(request, response);
			response.sendRedirect("/"+getServletContext().getInitParameter("app-name")+"/JSP/gerente/gerente.jsp");
		}
		
		/* FIM ! */
		
	}

}
