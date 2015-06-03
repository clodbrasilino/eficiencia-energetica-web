package br.edu.ifpi.see.servlets;

import java.io.IOException;

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
 * Servlet implementation class ServletAlterarSenha
 */
public class ServletAlterarSenhaAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarSenhaAdministrador() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String senhaAtual = request.getParameter("senhaAtual");
		String novaSenha = request.getParameter("novaSenha");
		String confirmacaoSenha = request.getParameter("confirmacaoSenha");
		
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
		
		if(senhaAtual.equals(u.getSenha())){
			if(confirmacaoSenha.equals(novaSenha)){
				
				UsuarioDAO dao = new UsuarioDAO();
				
				//EntityManager em = (EntityManager) getServletContext().getAttribute("em");
				EntityManager em = JPAUtil.getEntityManager();
				EntityTransaction et = em.getTransaction();
				
				et.begin();
				u.setSenha(novaSenha);
				dao.atualizar(u);
				et.commit();
				
				response.getWriter().println("<script>alert('Senha alterada com sucesso!')</script>");
				response.getWriter().println("<script>window.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/alterarDados.jsp'</script>");
			}else{
				response.getWriter().println("<script>alert('As senhas informadas são diferentes!')</script>");
				response.getWriter().println("<script>window.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/alterarDados.jsp'</script>");
			}
		}else{
			response.getWriter().println("<script>alert('Senha inválida!')</script>");
			response.getWriter().println("<script>window.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/alterarDados.jsp'</script>");
		}
		
	}

}
