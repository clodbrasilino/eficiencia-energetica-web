package br.edu.ifpi.see.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import br.edu.ifpi.see.request.Request;

public class IniciaRequestListener implements ServletContextListener {
	
    public IniciaRequestListener() {
    	
    }
    
    public void contextInitialized(ServletContextEvent arg0) {
    	new Thread(new Request(arg0)).start();
    }
    
    public void contextDestroyed(ServletContextEvent arg0) {
    	
    }
	
}
