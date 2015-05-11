package br.edu.ifpi.see.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.util.JPAUtil;

public class MicroControladorDAO implements GenericDAO<MicroControlador>{

	private EntityManager manager = JPAUtil.getEntityManager();
	
	@Override
	public void salvar(MicroControlador e) {
		// TODO Auto-generated method stub
		manager.persist(e);
	}

	@Override
	public void atualizar(MicroControlador e) {
		// TODO Auto-generated method stub
		manager.merge(e);
	}

	@Override
	public void apagar(MicroControlador e) {
		// TODO Auto-generated method stub
		manager.remove(pesquisar(e.getId()));
	}

	@Override
	public MicroControlador pesquisar(long id) {
		// TODO Auto-generated method stub
		return manager.find(MicroControlador.class, id);
	}

	@Override
	public List<MicroControlador> pesquisar(String jql) {
		// TODO Auto-generated method stub
		return manager.createQuery(jql, MicroControlador.class).getResultList();
	}

}
