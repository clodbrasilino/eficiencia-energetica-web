package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.Sala;

/**
 * Servlet implementation class ServletMicroControlador
 */
public class ServletMicroControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMicroControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Sala s = (Sala) request.getSession().getAttribute("sala");
		
		if(s != null){
			String ip = request.getParameter("ip");
			String porta = request.getParameter("porta");
			String presenca = request.getParameter("presenca");
			String lampadas = request.getParameter("lampadas");
			String ar = request.getParameter("ar");
			
			s.getListaMicroControlador().add(new MicroControlador(null, ip, Boolean.parseBoolean(porta), Boolean.parseBoolean(presenca), Boolean.parseBoolean(lampadas), Boolean.parseBoolean(ar)));
			request.getRequestDispatcher("/JSP/gerente/novaSala.jsp").forward(request, response);
		}
		
	}

}
