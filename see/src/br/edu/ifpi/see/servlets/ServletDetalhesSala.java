package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.SalaDAO;
import br.edu.ifpi.see.model.Sala;

/**
 * Servlet implementation class ServletDetalhesSala
 */
public class ServletDetalhesSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalhesSala() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Integer.parseInt(request.getParameter("id"));
		
		EntityTransaction et = ((EntityManager) getServletContext().getAttribute("em")).getTransaction();
		SalaDAO dao = new SalaDAO();
		
		et.begin();
		Sala s = dao.pesquisar(id);
		et.commit();
		
		request.setAttribute("sala", s);
		request.getRequestDispatcher("JSP/gerente/detalhesSala.jsp").forward(request, response);
		
	}

}
