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

import br.edu.ifpi.see.model.Administrador;
import br.edu.ifpi.see.model.Usuario;

public class FiltroAdministradorCadastrado implements Filter {

    public FiltroAdministradorCadastrado() {
    	
    }

	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession s = ((HttpServletRequest) request).getSession();
		Usuario u = (Usuario) s.getAttribute("usuario");
		if(u != null && u instanceof Administrador){
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse) response).sendRedirect("/"+request.getServletContext().getInitParameter("app-name")+"/");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
