package br.edu.ifpi.see.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpi.see.model.HistoricoMicroControlador;
import br.edu.ifpi.see.util.JPAUtil;

public class HistoricoMicroControladorDAO implements GenericDAO<HistoricoMicroControlador>{

	private EntityManager manager = JPAUtil.getEntityManager();
	
	@Override
	public void salvar(HistoricoMicroControlador e) {
		// TODO Auto-generated method stub
		manager.persist(e);
		
	}

	@Override
	public void atualizar(HistoricoMicroControlador e) {
		// TODO Auto-generated method stub
		manager.merge(e);
		
	}

	@Override
	public void apagar(HistoricoMicroControlador e) {
		// TODO Auto-generated method stub
		manager.remove(pesquisar(e.getId()));
		
	}

	@Override
	public HistoricoMicroControlador pesquisar(long id) {
		// TODO Auto-generated method stub
		return manager.find(HistoricoMicroControlador.class, id);
	}

	@Override
	public List<HistoricoMicroControlador> pesquisar(String jql) {
		// TODO Auto-generated method stub
		return manager.createQuery(jql, HistoricoMicroControlador.class).getResultList();
	}

}
