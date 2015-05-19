package br.edu.ifpi.see.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FiltroAdministradorCadastrado
 */
public class FiltroAdministradorCadastrado implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAdministradorCadastrado() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	// TODO Implementar Filtro Administrador Cadastrado
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		System.out.println("FiltroAdmistradorCadastrado");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
