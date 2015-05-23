package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Usuario;
import br.edu.ifpi.see.util.JPAUtil;

/**
 * Servlet implementation class ServletDetalhesGerente
 */
public class ServletDetalhesGerente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalhesGerente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Integer.parseInt(request.getParameter("id"));
		
		EntityTransaction et = JPAUtil.getTransaction();
		UsuarioDAO dao = new UsuarioDAO();
		
		et.begin();
		Usuario u = dao.pesquisar(id);
		et.commit();
		
		PrintWriter out = response.getWriter();
		out.println(u);
		
		request.setAttribute("gerente", u);
		request.getRequestDispatcher("JSP/administrador/detalhesGerente.jsp").forward(request, response);
		
	}

}
