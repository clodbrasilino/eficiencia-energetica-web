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
 * Servlet implementation class ServletAlterarAdministrador
 */
public class ServletAlterarDadosAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarDadosAdministrador() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/alterarDados.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		//EntityTransaction et = ((EntityManager) getServletContext().getAttribute("em")).getTransaction();
		EntityTransaction et = JPAUtil.getTransaction();
		
		et.begin();
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario u = dao.pesquisar(id);
		u.setNome(nome);
		u.setEndereco(endereco);
		u.setEmail(email);
		u.setTelefone(telefone);
		
		dao.atualizar(u);
		et.commit();
		
		response.getWriter().println("<script>alert('Dados atualizados com sucesso!')</script>");
		response.getWriter().println("<script>window.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/administrador.jsp'</script>");
		
	}

}
