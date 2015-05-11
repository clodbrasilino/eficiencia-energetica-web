package br.edu.ifpi.see.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpi.see.model.Sala;
import br.edu.ifpi.see.util.JPAUtil;

public class SalaDAO implements GenericDAO<Sala>{

	private EntityManager manager = JPAUtil.getEntityManager();
	
	@Override
	public void salvar(Sala e) {
		// TODO Auto-generated method stub
		manager.persist(e);
	}

	@Override
	public void atualizar(Sala e) {
		// TODO Auto-generated method stub
		manager.merge(e);
	}

	@Override
	public void apagar(Sala e) {
		// TODO Auto-generated method stub
		manager.remove(pesquisar(e.getId()));
	}

	@Override
	public Sala pesquisar(long id) {
		// TODO Auto-generated method stub
		return manager.find(Sala.class, id);
	}

	@Override
	public List<Sala> pesquisar(String jql) {
		// TODO Auto-generated method stub
		return manager.createQuery(jql, Sala.class).getResultList();
	}

}
