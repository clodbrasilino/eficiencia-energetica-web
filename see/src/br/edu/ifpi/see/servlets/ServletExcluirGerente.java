package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Usuario;
import br.edu.ifpi.see.util.JPAUtil;

/**
 * Servlet implementation class ServletExcluirGerente
 */
public class ServletExcluirGerente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirGerente() {
        super();
    }
    
    // TODO Implementar Servlet de Excluir Gerente

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Integer.parseInt(request.getParameter("id"));
		
		/*EntityTransaction et = JPAUtil.getTransaction();
		EntityManager em = JPAUtil.getEntityManager();*/
		
		EntityManager em = (EntityManager) getServletContext().getAttribute("em");
		EntityTransaction et = em.getTransaction();
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario u = dao.pesquisar(id);
		
		et.begin();
		dao.apagar(u);
		et.commit();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('Gerente de salas excluído com sucesso!')");
		out.println("document.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/administrador.jsp'");
		out.println("</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
