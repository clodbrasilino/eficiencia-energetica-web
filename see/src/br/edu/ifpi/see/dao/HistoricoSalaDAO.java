package br.edu.ifpi.see.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpi.see.model.HistoricoSala;
import br.edu.ifpi.see.model.Sala;
import br.edu.ifpi.see.util.JPAUtil;

public class HistoricoSalaDAO implements GenericDAO<HistoricoSala> {

	private EntityManager manager = JPAUtil.getEntityManager();

	@Override
	public void salvar(HistoricoSala e) {
		manager.persist(e);
	}

	@Override
	public void atualizar(HistoricoSala e) {
		manager.merge(e);
	}

	@Override
	public void apagar(HistoricoSala e) {
		manager.remove(pesquisar(e.getId()));
	}

	@Override
	public HistoricoSala pesquisar(long id) {
		return manager.find(HistoricoSala.class, id);
	}

	@Override
	public List<HistoricoSala> pesquisar(String jql) {
		return manager.createQuery(jql, HistoricoSala.class).getResultList();
	}

	public List<HistoricoSala> pesquisar(Calendar data) {
		Query q = manager.createQuery("select hs from HistoricoSala hs where hs.data = :data", HistoricoSala.class);
		q.setParameter("data", data);
		return q.getResultList();
	}

	public List<HistoricoSala> pesquisar(Calendar dataInicial, Calendar dataFinal) {
		Query q = manager.createQuery("select hs from HistoricoSala hs where hs.data between :dataInicial and :dataFinal", HistoricoSala.class);
		q.setParameter("dataInicial", dataInicial);
		q.setParameter("dataFinal", dataFinal);
		return q.getResultList();
	}
	
	public List<HistoricoSala> pesquisar(Sala sala, Calendar data) {
		Query q = manager.createQuery("select hs from HistoricoSala hs where hs.sala = :sala and hs.data = :data", HistoricoSala.class);
		q.setParameter("sala", sala);
		q.setParameter("data", data);
		return q.getResultList();
	}
	
	public List<HistoricoSala> pesquisar(Sala sala, Calendar dataInicial, Calendar dataFinal) {
		Query q = manager.createQuery("select hs from HistoricoSala hs where hs.sala = :sala and hs.data between :dataInicial and :dataFinal", HistoricoSala.class);
		q.setParameter("sala", sala);
		q.setParameter("dataInicial", dataInicial);
		q.setParameter("dataFinal", dataFinal);
		return q.getResultList();
	}

}
