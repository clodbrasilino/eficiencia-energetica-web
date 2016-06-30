package br.edu.ifpi.see.request;

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

	public Request(ServletContextEvent evt) {
		this.evt = evt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {

		GeneratedStatus gs = new GeneratedStatus();

		HistoricoSalaDAO historicoDao = new HistoricoSalaDAO();

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();

		while (true) {

			
			this.salas = (List<Sala>) evt.getServletContext().getAttribute("salas");
			while(this.salas == null){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				this.salas = (List<Sala>) evt.getServletContext().getAttribute("salas");
			}

			synchronized (this.salas) {

				for (Sala s : this.salas) {

					s.setStatus(gs.getStatus(s.getListaMicroControlador()));

					if (s.hasStatusAtual()) {
						Calendar data = Calendar.getInstance();
						data.setTime(new Date());
						et.begin();
						historicoDao.salvar(new HistoricoSala(data, s));
						et.commit();
					} else if(s.getStatusAnterior() == null){
						Calendar data = Calendar.getInstance();
						data.setTime(new Date());
						et.begin();
						historicoDao.salvar(new HistoricoSala(data, s));
						et.commit();
					}

				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}

			}

		}

	}

}
