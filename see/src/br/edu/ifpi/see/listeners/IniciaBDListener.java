package br.edu.ifpi.see.listeners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class IniciaBDListener
 *
 */
public class IniciaBDListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public IniciaBDListener() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         arg0.getServletContext().setAttribute("em",  Persistence.createEntityManagerFactory("sistema").createEntityManager());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	 EntityManager em = (EntityManager) arg0.getServletContext().getAttribute("em");
    	 if (em != null) {
	         EntityManagerFactory emf = ((EntityManager) arg0.getServletContext().getAttribute("em")).getEntityManagerFactory();
	         em.close();
	         emf.close();
    	 }
    }
	
}
