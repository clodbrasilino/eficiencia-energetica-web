package br.edu.ifpi.see.listeners;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import br.edu.ifpi.see.dao.SalaDAO;
import br.edu.ifpi.see.model.Sala;

public class CarregaListaDeSalasListener implements ServletRequestListener {

    public CarregaListaDeSalasListener() {
    	
    }
    
    public void requestInitialized(ServletRequestEvent arg0) {
    	
    	SalaDAO dao = new SalaDAO();
    	
    	List<Sala> salas = dao.pesquisar("select s from Sala s");
    	
    	arg0.getServletContext().setAttribute("salas", salas);
    	
    }
    
    public void requestDestroyed(ServletRequestEvent arg0) {
    	
    }
	
}
