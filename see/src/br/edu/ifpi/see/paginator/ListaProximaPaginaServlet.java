package br.edu.ifpi.see.paginator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaProximaPaginaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaProximaPaginaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Paginator p = (Paginator) request.getSession().getAttribute("paginator");
		p.chamaProximaLista();
		response.sendRedirect("/see/listar-gerentes");
	}

}
