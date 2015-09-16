package br.edu.ifpi.see.filtros;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.edu.ifpi.see.util.JPAUtil;

public class FiltroTransactionManager implements Filter {

    public FiltroTransactionManager() {
    	
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//EntityManager em = (EntityManager) request.getServletContext().getAttribute("em");
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		chain.doFilter(request, response);
		
		try{
			et.commit();
		} catch (Exception e){
			et.rollback();
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
