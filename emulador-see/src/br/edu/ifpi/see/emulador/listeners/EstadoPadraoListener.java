package br.edu.ifpi.see.emulador.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.edu.ifpi.see.emulador.model.Estado;
import br.edu.ifpi.see.emulador.model.EstadoEmulador;

@WebListener
public class EstadoPadraoListener implements ServletContextListener {

    public EstadoPadraoListener() {
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	arg0.getServletContext().setAttribute("estadoAtual", new EstadoEmulador(Estado.LIGADO, Estado.LIGADO, Estado.LIGADO, Estado.LIGADO));
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

}
