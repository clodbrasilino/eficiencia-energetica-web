package br.edu.ifpi.see.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpi.see.model.HistoricoSala;
import br.edu.ifpi.see.util.JPAUtil;

public class HistoricoSalaDAO implements GenericDAO<HistoricoSala>{

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

}
