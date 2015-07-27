package br.edu.ifpi.see.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpi.see.model.Usuario;

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
		
		HttpSession s = ((HttpServletRequest) request).getSession();
		Usuario u = (Usuario) s.getAttribute("usuario");
		if((u!= null && u.getTipo() == 1)){
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse) response).sendRedirect("/"+request.getServletContext().getInitParameter("app-name")+"/");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
