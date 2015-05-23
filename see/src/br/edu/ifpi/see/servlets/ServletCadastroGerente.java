package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Usuario;
import br.edu.ifpi.see.util.JPAUtil;

/**
 * Servlet implementation class ServletCadastroGerente
 */
public class ServletCadastroGerente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastroGerente() {
        super();
    }
    
    // TODO Implementar Servlet de Cadastrar Gerente

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		String confirmacaoSenha = request.getParameter("ConfirmacaoSenha");
		
		Usuario u = new Usuario();
		u.setNome(nome);
		u.setEndereco(endereco);
		u.setEmail(email);
		u.setTelefone(telefone);
		u.setSenha(senha);
		u.setTipo(2);
		u.setAtivo(true);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		if(senha.equals(confirmacaoSenha)){
			em.getTransaction().begin();
			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(u);
			em.getTransaction().commit();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Gerente de salas cadastrado com sucesso!')");
			out.println("document.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/administrador.jsp'");
			out.println("</script>");
		}else{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('As senhas informadas são diferentes!')");
			out.println("document.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/novoGerente.jsp'");
			out.println("</script>");
		}
		
		//response.sendRedirect("/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/administrador.jsp");
		
	}

}
