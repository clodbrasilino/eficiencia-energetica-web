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
	 *  - Função do filtro: Validar o login.
	 * 	- Esse filtro NÃO FAZ o reconhecimento do usuário.
	 *  - Fará apenas uma consulta do banco, para saber se há um usuário cadastrado com 'email' e 'senha' informados.
	 * 
	 * 	- Validações de login:
	 * 		-> Verificar se os dois campos foram preenchidos
	 * 		-> Verifica se o email possui um caractere '@' 
	 * 
	 * 	- Caso algum erro seja encontrado, uma mensagem será gerada e enviada para a pagina inicial do sistema. 
	 * 
	 * 	- Fluxo:
	 * 		-> Validar formulario de login
	 * 		-> Caso válido( preenchido corretamente ):
	 * 			- Consultar usuario com 'email' e 'senha' informados.
	 * 			- Setar usuário como atributo de sessão.
	 * 			- Redirecionar para servlet de Indentificação de usuário.
	 * 		
	 *      -> Caso inválido:
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
		 * 	- Em alguns momentos da exeução da aplicação, esse filtro será chamado já com um usuário na sessão.
		 * 	- Nesse caso é só redirecionar para o sevlet 'ServletIndentificaUsuario'.
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
		
		/* Na primeira execução desse Filtro, o usuário será nulo */
		u = null;
		
		
		/*	Caso o usuário não didite 'email' nem 'senha' */
		if("".equals(email) && "".equals(senha)){
			s.setAttribute("mensagem", "Preencha e-mail e senha");
			((HttpServletResponse) response).sendRedirect("/"+request.getServletContext().getInitParameter("app-name")+"/");
			return;
		}
		
		/* Caso o usuário não digite o email: */
		else if(email == null){
			s.setAttribute("mensagem", "Preencha o e-mail");
			((HttpServletResponse) response).sendRedirect("/"+request.getServletContext().getInitParameter("app-name")+"/");
			return;
		}
		
		/* Caso o usuário não digite a senha: */
		else if("".equals(senha)){
			s.setAttribute("mensagem", "Digite uma senha válida");
			((HttpServletResponse) response).sendRedirect("/"+request.getServletContext().getInitParameter("app-name")+"/");
			return;
		}
		
		/* Caso o usuário digite o e-mail sem o caractere '@': */
		else if(!email.contains("@")){
			s.setAttribute("mensagem", "Digite um e-mail válido");
			((HttpServletResponse) response).sendRedirect("/"+request.getServletContext().getInitParameter("app-name")+"/");
			return;
		}
		
//		EntityManager em = JPAUtil.getEntityManager();
		EntityManager em = (EntityManager) request.getServletContext().getAttribute("em");
		
		em.getTransaction().begin();
		u = dao.pesquisar(email, senha);
		em.getTransaction().commit();
		
		/* Se o usuário preencher 'e-mail' e 'senha' válidos, mas não for cadastrado no sistema: */
		if(u == null){
			s.setAttribute("mensagem", "Usuário não cadastrado.");
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
