package br.edu.ifpi.see.listeners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class IniciaBDListener implements ServletContextListener {

	public IniciaBDListener() {

	}

	public void contextInitialized(ServletContextEvent arg0) {
		
		arg0.getServletContext().setAttribute("em", Persistence.createEntityManagerFactory("sistema").createEntityManager());
		
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		EntityManager em = (EntityManager) arg0.getServletContext().getAttribute("em");
		if (em != null) {
			EntityManagerFactory emf = ((EntityManager) arg0.getServletContext().getAttribute("em")).getEntityManagerFactory();
			em.close();
			emf.close();
		}
	}

}
