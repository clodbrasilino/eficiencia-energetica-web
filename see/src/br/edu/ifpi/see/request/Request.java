package br.edu.ifpi.see.request;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletContextEvent;

import br.edu.ifpi.see.dao.HistoricoSalaDAO;
import br.edu.ifpi.see.model.HistoricoSala;
import br.edu.ifpi.see.model.Sala;
import br.edu.ifpi.see.util.JPAUtil;

public class Request implements Runnable {
	
	private ServletContextEvent evt;
	private List<Sala> salas;
	
	public Request(ServletContextEvent evt){
		this.evt = evt;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		
		GeneratedStatus gs = new GeneratedStatus();
    	
		HistoricoSalaDAO historicoDao = new HistoricoSalaDAO();
		
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		DateFormat dt = new SimpleDateFormat("HH:mm:ss");
		
		while(true){
			
			this.salas = (List<Sala>) evt.getServletContext().getAttribute("salas");
			
			for(Sala s : this.salas){
				
				s.setStatus(gs.getStatus(s.getListaMicroControlador()));
				
				if(s.hasStatusAtual()){
					Calendar data = Calendar.getInstance();
					data.setTime(new Date());
					et.begin();
					historicoDao.salvar(new HistoricoSala(data, s));
					et.commit();
					
					System.out.println("Hora: " + dt.format(s.getStatus().getTime().getTime()) + " Sala: " + s.getNumero() + " Status: " + s.getStatus().getDescricao());
				}
				
			}
			System.out.println();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
		
	}
	
}
