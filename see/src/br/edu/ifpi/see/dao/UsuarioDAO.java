package br.edu.ifpi.see.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpi.see.model.Usuario;
import br.edu.ifpi.see.util.JPAUtil;

public class UsuarioDAO implements GenericDAO<Usuario>{

	private EntityManager manager = JPAUtil.getEntityManager();
	
	@Override
	public void salvar(Usuario e) {
		// TODO Auto-generated method stub
		manager.persist(e);
	}

	@Override
	public void atualizar(Usuario e) {
		// TODO Auto-generated method stub
		manager.merge(e);
	}

	@Override
	public void apagar(Usuario e) {
		// TODO Auto-generated method stub
		manager.remove(pesquisar(e.getId()));
	}

	@Override
	public Usuario pesquisar(long id) {
		// TODO Auto-generated method stub
		return manager.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> pesquisar(String jql) {
		// TODO Auto-generated method stub
		return manager.createQuery(jql, Usuario.class).getResultList();
	}
	
	public Usuario pesquisar(String email, String senha) {
		
		List<Usuario> usuarios = pesquisar("select u from Usuario u");
		
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		
		return null;
	}

}
