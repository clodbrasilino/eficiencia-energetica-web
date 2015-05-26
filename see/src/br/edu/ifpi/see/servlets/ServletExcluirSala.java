package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.SalaDAO;
import br.edu.ifpi.see.model.Sala;

/**
 * Servlet implementation class ServletExcluirSala
 */
public class ServletExcluirSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirSala() {
        super();
    }
    
    // TODO Implementar Servlet de Excluir Sala

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
long id = Integer.parseInt(request.getParameter("id"));
		
		/*EntityTransaction et = JPAUtil.getTransaction();
		EntityManager em = JPAUtil.getEntityManager();*/
		
		EntityManager em = (EntityManager) getServletContext().getAttribute("em");
		EntityTransaction et = em.getTransaction();
		
		SalaDAO dao = new SalaDAO();
		
		Sala s = dao.pesquisar(id);
		
		et.begin();
		dao.apagar(s);
		et.commit();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('Sala excluída com sucesso!')");
		out.println("document.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/gerente/gerente.jsp'");
		out.println("</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
