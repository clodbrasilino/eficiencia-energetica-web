package br.edu.ifpi.see.listeners;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.edu.ifpi.see.dao.SalaDAO;
import br.edu.ifpi.see.model.Sala;

public class IniciaListaDeSalasListener implements ServletContextListener {

    public IniciaListaDeSalasListener() {
    	
    }
    
    public void contextInitialized(ServletContextEvent arg0) {
    	
    	SalaDAO dao = new SalaDAO();
    	
    	List<Sala> salas = dao.pesquisar("select s from Sala s");
    	
    	arg0.getServletContext().setAttribute("salas", salas);
    	
    }
    
    public void contextDestroyed(ServletContextEvent arg0) {
    	
    }
	
}
