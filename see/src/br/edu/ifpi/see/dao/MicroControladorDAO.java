package br.edu.ifpi.see.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.util.JPAUtil;

public class MicroControladorDAO implements GenericDAO<MicroControlador>{

	private EntityManager manager = JPAUtil.getEntityManager();
	
	@Override
	public void salvar(MicroControlador e) {
		manager.persist(e);
	}

	@Override
	public void atualizar(MicroControlador e) {

		manager.merge(e);
	}

	@Override
	public void apagar(MicroControlador e) {
		
		manager.remove(pesquisar(e.getId()));
	}

	@Override
	public MicroControlador pesquisar(long id) {
		
		return manager.find(MicroControlador.class, id);
	}

	@Override
	public List<MicroControlador> pesquisar(String jql) {
		
		return manager.createQuery(jql, MicroControlador.class).getResultList();
	}
	
	public long getUltimoId(){
		MicroControlador mc = manager.createQuery("select max(mc) from MicroControlador mc", MicroControlador.class).getSingleResult();
		return mc.getId() + 1;
	}
	
}
