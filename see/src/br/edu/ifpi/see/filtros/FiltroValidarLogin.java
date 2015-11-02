package br.edu.ifpi.see.filtros;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Usuario;

/**
 * Servlet Filter implementation class FiltroValidarLogin
 */
public class FiltroValidarLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroValidarLogin() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

	/**
	 *  - Fun��o do filtro: Validar o login.
	 * 	- Esse filtro N�O FAZ o reconhecimento do usu�rio.
	 *  - Far� apenas uma consulta do banco, para saber se h� um usu�rio cadastrado com 'email' e 'senha' informados.
	 * 
	 * 	- Valida��es de login:
	 * 		-> Verificar se os dois campos foram preenchidos
	 * 		-> Verifica se o email possui um caractere '@' 
	 * 
	 * 	- Caso algum erro seja encontrado, uma mensagem ser� gerada e enviada para a pagina inicial do sistema. 
	 * 
	 * 	- Fluxo:
	 * 		-> Validar formulario de login
	 * 		-> Caso v�lido( preenchido corretamente ):
	 * 			- Consultar usuario com 'email' e 'senha' informados.
	 * 			- Setar usu�rio como atributo de sess�o.
	 * 			- Redirecionar para servlet de Indentifica��o de usu�rio.
	 * 		
	 *      -> Caso inv�lido:
	 *      	- Enviar mensagem de erro para 'index.jsp'.
	 *      
	 *      
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession s = ((HttpServletRequest) request).getSession();
		if(request.getServletContext().getInitParameter("debug").equals("true")){
			System.out.println("FiltroValidarLogin.doFilter() - entrou!");
		}
		
		
		/*
		 * 	- Em alguns momentos da exeu��o da aplica��o, esse filtro ser� chamado j� com um usu�rio na sess�o.
		 * 	- Nesse caso � s� redirecionar para o sevlet 'ServletIndentificaUsuario'.
		 */
		Usuario u = (Usuario) s.getAttribute("usuario");
		if (u != null){
			request.getRequestDispatcher("/"+request.getServletContext().getInitParameter("app-name")+"/ServletIndentificaUsuario").forward(request, response);
			return;
		}
		
		
		/*
		 *  Pega os atributos do credenciamento:
		 */
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		/*	Instancia um DAO para a consulta no banco */
		UsuarioDAO dao = new UsuarioDAO();
		
		/* Na primeira execu��o desse Filtro, o usu�rio ser� nulo */
		u = null;
		
		
		/*	Caso o usu�rio n�o didite 'email' nem 'senha' */
		if("".equals(email) && "".equals(senha)){
			s.setAttribute("mensagem", "Preencha e-mail e senha");
			((HttpServletResponse) response).sendRedirect("/"+request.getServletContext().getInitParameter("app-name")+"/");
			return;
		}
		
		/* Caso o usu�rio n�o digite o email: */
		else if(email == null){
			s.setAttribute("mensagem", "Preencha o e-mail");
			((HttpServletResponse) response).sendRedirect("/"+request.getServletContext().getInitParameter("app-name")+"/");
			return;
		}
		
		/* Caso o usu�rio n�o digite a senha: */
		else if("".equals(senha)){
			s.setAttribute("mensagem", "Digite uma senha v�lida");
			((HttpServletResponse) response).sendRedirect("/"+request.getServletContext().getInitParameter("app-name")+"/");
			return;
		}
		
		/* Caso o usu�rio digite o e-mail sem o caractere '@': */
		else if(!email.contains("@")){
			s.setAttribute("mensagem", "Digite um e-mail v�lido");
			((HttpServletResponse) response).sendRedirect("/"+request.getServletContext().getInitParameter("app-name")+"/");
			return;
		}
		
//		EntityManager em = JPAUtil.getEntityManager();
		EntityManager em = (EntityManager) request.getServletContext().getAttribute("em");
		
		em.getTransaction().begin();
		u = dao.pesquisar(email, senha);
		em.getTransaction().commit();
		
		/* Se o usu�rio preencher 'e-mail' e 'senha' v�lidos, mas n�o for cadastrado no sistema: */
		if(u == null){
			s.setAttribute("mensagem", "Usu�rio n�o cadastrado.");
			((HttpServletResponse) response).sendRedirect("/"+request.getServletContext().getInitParameter("app-name")+"/");
			return;
		}
		
		
		/* Se tudo der certo:  */
		else {
			((HttpServletRequest) request).getSession().setAttribute("usuario", u);
			/* A vida continua */
			chain.doFilter(request, response);
		
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {}

}
