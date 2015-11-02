package br.edu.ifpi.see.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpi.see.model.Gerente;
import br.edu.ifpi.see.model.Usuario;
import br.edu.ifpi.see.util.JPAUtil;

public class UsuarioDAO implements GenericDAO<Usuario>{

	private EntityManager manager = JPAUtil.getEntityManager();
	
	@Override
	public void salvar(Usuario e) {

		manager.persist(e);
	}

	@Override
	public void atualizar(Usuario e) {

		manager.merge(e);
	}

	@Override
	public void apagar(Usuario e) {
		
		((Gerente) e).setAtivo(false);
		manager.merge(e);
	}

	@Override
	public Usuario pesquisar(long id) {

		return manager.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> pesquisar(String jql) {

		return manager.createQuery(jql, Usuario.class).getResultList();
	}
	
	public Usuario pesquisar(String email, String senha) {
		
		Query q = manager.createQuery("select u from Usuario u where u.ativo = :ativo");
		q.setParameter("ativo", true);
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = q.getResultList();
		
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Usuario> listaGerentes() throws SQLException{
		return (ArrayList<Usuario>) manager.createQuery("select u from Usuario u where tipo = 'Gerente'").getResultList();
	}
	
	public long getUltimoId(){
		Usuario u = manager.createQuery("select max(u) from Usuario u", Usuario.class).getSingleResult();
		return u.getId() + 1;
	}

}
