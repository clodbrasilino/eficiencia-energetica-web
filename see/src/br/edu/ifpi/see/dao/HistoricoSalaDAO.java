package br.edu.ifpi.see.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpi.see.model.HistoricoSala;
import br.edu.ifpi.see.util.JPAUtil;

public class HistoricoSalaDAO implements GenericDAO<HistoricoSala>{

	private EntityManager manager = JPAUtil.getEntityManager();
	
	@Override
	public void salvar(HistoricoSala e) {
		// TODO Auto-generated method stub
		manager.persist(e);
	}

	@Override
	public void atualizar(HistoricoSala e) {
		// TODO Auto-generated method stub
		manager.merge(e);
	}

	@Override
	public void apagar(HistoricoSala e) {
		// TODO Auto-generated method stub
		manager.remove(pesquisar(e.getId()));
	}

	@Override
	public HistoricoSala pesquisar(long id) {
		// TODO Auto-generated method stub
		return manager.find(HistoricoSala.class, id);
	}

	@Override
	public List<HistoricoSala> pesquisar(String jql) {
		// TODO Auto-generated method stub
		return manager.createQuery(jql, HistoricoSala.class).getResultList();
	}

}
