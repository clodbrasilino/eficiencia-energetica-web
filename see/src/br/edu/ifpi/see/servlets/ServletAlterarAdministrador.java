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

/**
 * Servlet implementation class ServletAlterarAdministrador
 */
public class ServletAlterarAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarAdministrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/alterarAdministrador.jsp");
		
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
		String senha = request.getParameter("senha");
		
		EntityTransaction et = ((EntityManager) getServletContext().getAttribute("em")).getTransaction();
		
		et.begin();
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario u = dao.pesquisar(id);
		u.setNome(nome);
		u.setEndereco(endereco);
		u.setEmail(email);
		u.setTelefone(telefone);
		u.setSenha(senha);
		
		dao.atualizar(u);
		et.commit();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('Dados atualizados com sucesso!')");
		out.println("document.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/administrador.jsp'");
		out.println("</script>");
		
	}

}
