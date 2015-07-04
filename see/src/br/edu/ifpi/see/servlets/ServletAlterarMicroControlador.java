package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.MicroControladorDAO;
import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.Sala;

/**
 * Servlet implementation class ServletAlterarMicroControlador
 */
public class ServletAlterarMicroControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarMicroControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Integer.parseInt(request.getParameter("id"));
		
		EntityTransaction et = ((EntityManager) getServletContext().getAttribute("em")).getTransaction();
		
		et.begin();
		MicroControladorDAO dao = new MicroControladorDAO();
		MicroControlador mc = dao.pesquisar(id);
		et.commit();
		request.getSession().setAttribute("micro", mc);
		
		request.getRequestDispatcher("JSP/gerente/alterarMicroControlador.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Sala s = (Sala) request.getSession().getAttribute("sala");
		
		MicroControladorDAO dao = new MicroControladorDAO();
		MicroControlador mc = (MicroControlador) request.getSession().getAttribute("micro");
		
		mc.setSensorAr(Boolean.parseBoolean(request.getParameter("ar")));
		mc.setSensorLampada(Boolean.parseBoolean(request.getParameter("lampadas")));
		mc.setSensorPorta(Boolean.parseBoolean(request.getParameter("porta")));
		mc.setSensorPresenca(Boolean.parseBoolean(request.getParameter("presenca")));
		
		dao.atualizar(mc);
		
		request.getSession().removeAttribute("micro");
		response.sendRedirect("/" + getServletContext().getInitParameter("app-name") + "/ServletAlterarSala?id=" + s.getId());
		
	}

}
