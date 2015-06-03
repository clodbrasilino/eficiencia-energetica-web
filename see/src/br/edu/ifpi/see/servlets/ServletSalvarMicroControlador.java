package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.Sala;

/**
 * Servlet implementation class ServletSalvarMicroControlador
 */
public class ServletSalvarMicroControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarMicroControlador() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ip = request.getParameter("ip");
		String porta = request.getParameter("porta");
		String presenca = request.getParameter("presenca");
		String lampadas = request.getParameter("lampadas");
		String ar = request.getParameter("ar");
		
		Sala s = (Sala) request.getSession().getAttribute("sala");
		
		s.getListaMicroControlador().add(new MicroControlador(null, ip, Boolean.parseBoolean(porta), Boolean.parseBoolean(presenca), Boolean.parseBoolean(lampadas), Boolean.parseBoolean(ar)));
		response.sendRedirect("/"+getServletContext().getInitParameter("app-name")+"/JSP/gerente/novaSala.jsp");
	}

}
