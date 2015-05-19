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
	 * 	Função do Filtro: Verificar se existe um Gerente Logado.
	 * 
	 * 	Filtra as páginas: 'gerente.jsp', 'novoSala.jsp', 'alterarSala.jsp', 'detalheSala.jsp'
	 * 	Fitra o Servlet de exclusão de sala.
	 * 
	 *  Caso o usuário esteja cadastrado, a página requisitada carrega normalmente.
	 *  Caso não, uma página de login alternativo será chamada.
	 *  
	 *  
	 *  Fluxo:
	 *  	- Receber usuário
	 *  	- Verificar se é gerente.
	 *  	- Caso não seja:
	 *  		- Redirecionar para 'login.jsp'
	 *  	- Caso seja:	
	 *  		'chain.doFilter(request, response);'
	 *  		- A requisição segue normalmente
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("FiltroGerenteCadastrado");
		
		/* Receber Usuário */
		Usuario u = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("usuario");
		
		/* Fazer a verificação */
		if(u.getTipo() != 2){
			/* Não é gerente. Precisa se logar */
			request.setAttribute("mensagem", "Você não é um gerente. Se for, precisa se logar primeiro.");
			/* Redirecionando para a uma tela de login alternativo */
			request.getRequestDispatcher("/"+request.getServletContext().getInitParameter("app-name")+"/JSP/login.jsp").forward(request, response);
			/* Para a execução por aqui mesmo */
			return;
		}
		else{
			/* É gerente. A vida continua */
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
