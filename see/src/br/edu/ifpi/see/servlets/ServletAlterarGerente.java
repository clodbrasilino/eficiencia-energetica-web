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
 * Servlet implementation class ServletAlterarGerente
 */
public class ServletAlterarGerente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarGerente() {
        super();
    }
    
    // TODO Implementar Servlet de Alterar Gerente

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
//		EntityTransaction et = JPAUtil.getTransaction();
		EntityTransaction et = ((EntityManager) getServletContext().getAttribute("em")).getTransaction();
		
		et.begin();
		UsuarioDAO dao = new UsuarioDAO();
		Usuario u = dao.pesquisar(id);
		et.commit();
		request.setAttribute("usuario", u);
		
		request.getRequestDispatcher("JSP/administrador/alterarGerente.jsp").forward(request, response);
		
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
		
//		EntityTransaction et = JPAUtil.getTransaction();
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
		out.println("alert('Gerente de salas atualizado com sucesso!')");
		out.println("document.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/administrador.jsp'");
		out.println("</script>");
	}

}
