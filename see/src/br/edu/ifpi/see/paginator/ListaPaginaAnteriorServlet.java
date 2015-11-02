package br.edu.ifpi.see.paginator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaPaginaAnteriorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaPaginaAnteriorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resource = request.getParameter("resource");
		Paginator p = (Paginator) request.getSession().getAttribute("paginator");
		p.chamaListaAnterior();
		response.sendRedirect(resource);
	}

}
