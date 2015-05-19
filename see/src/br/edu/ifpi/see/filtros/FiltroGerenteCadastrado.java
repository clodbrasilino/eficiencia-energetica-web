package br.edu.ifpi.see.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import br.edu.ifpi.see.model.Usuario;

/**
 * Servlet Filter implementation class FiltroGerenteCadastrado
 */
public class FiltroGerenteCadastrado implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroGerenteCadastrado() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * 	Fun��o do Filtro: Verificar se existe um Gerente Logado.
	 * 
	 * 	Filtra as p�ginas: 'gerente.jsp', 'novoSala.jsp', 'alterarSala.jsp', 'detalheSala.jsp'
	 * 	Fitra o Servlet de exclus�o de sala.
	 * 
	 *  Caso o usu�rio esteja cadastrado, a p�gina requisitada carrega normalmente.
	 *  Caso n�o, uma p�gina de login alternativo ser� chamada.
	 *  
	 *  
	 *  Fluxo:
	 *  	- Receber usu�rio
	 *  	- Verificar se � gerente.
	 *  	- Caso n�o seja:
	 *  		- Redirecionar para 'login.jsp'
	 *  	- Caso seja:	
	 *  		'chain.doFilter(request, response);'
	 *  		- A requisi��o segue normalmente
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("FiltroGerenteCadastrado");
		
		/* Receber Usu�rio */
		Usuario u = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("usuario");
		
		/* Fazer a verifica��o */
		if(u.getTipo() != 2){
			/* N�o � gerente. Precisa se logar */
			request.setAttribute("mensagem", "Voc� n�o � um gerente. Se for, precisa se logar primeiro.");
			/* Redirecionando para a uma tela de login alternativo */
			request.getRequestDispatcher("/"+request.getServletContext().getInitParameter("app-name")+"/JSP/login.jsp").forward(request, response);
			/* Para a execu��o por aqui mesmo */
			return;
		}
		else{
			/* � gerente. A vida continua */
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
