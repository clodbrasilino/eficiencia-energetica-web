package br.edu.ifpi.see.control.administrador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.paginator.Paginator;

public class ListaGerentesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaGerentesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO dao = new UsuarioDAO();
		HttpSession sessao = request.getSession();
		Paginator p = (Paginator) sessao.getAttribute("paginator");
		
		try {
			p.setLista(dao.listaGerentes());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		p.setLinhas(5);
		sessao.setAttribute("gerentes", p.getSublista());
		
		response.sendRedirect("/see/JSP/administrador/administrador.jsp");
	}

}
