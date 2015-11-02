package br.edu.ifpi.see.paginator;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class IniciaPaginatorListener implements HttpSessionListener {

    public IniciaPaginatorListener() {
    	
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
    	arg0.getSession().setAttribute("paginator", new Paginator());
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	
    }
	
}
