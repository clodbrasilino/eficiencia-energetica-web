package br.edu.ifpi.see.listeners;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.edu.ifpi.see.dao.SalaDAO;
import br.edu.ifpi.see.model.Sala;

public class IniciaListaDeSalasListener implements ServletContextListener {

    public IniciaListaDeSalasListener() {
    	
    }
    
    public void contextInitialized(ServletContextEvent arg0) {
    	
    	EntityManager em = (EntityManager) arg0.getServletContext().getAttribute("em");
    	EntityTransaction et = em.getTransaction();
    	
    	SalaDAO dao = new SalaDAO();
    	
    	et.begin();
    	List<Sala> salas = dao.pesquisar("select s from Sala s");
    	et.commit();
    	
    	arg0.getServletContext().setAttribute("salas", salas);
    	
    }
    
    public void contextDestroyed(ServletContextEvent arg0) {
    	
    }
	
}
