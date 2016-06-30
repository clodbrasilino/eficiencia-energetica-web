package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.Sala;

/**
 * Servlet implementation class ServletSala
 */
public class ServletSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSala() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Sala s = (Sala) request.getSession().getAttribute("sala");
		if(s == null){
			String numero = request.getParameter("numero");
			String descricao = request.getParameter("descricao");
			int pavimento = Integer.parseInt(request.getParameter("pavimento"));
			
			s = new Sala();
			s.setNumero(numero);
			s.setDescricao(descricao);
			s.setPavimento(pavimento);
			s.setListaMicroControlador(new ArrayList<MicroControlador>());
			
			request.getSession().setAttribute("sala", s);
		}
		
		request.getRequestDispatcher("/JSP/gerente/novoMicroControlador.jsp").forward(request, response);
		
	}

}
