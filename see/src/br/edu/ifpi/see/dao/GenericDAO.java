package br.edu.ifpi.see.dao;

import java.util.List;

public interface GenericDAO <Entity>{
	
	public void salvar(Entity e); 
	public void atualizar(Entity e);
	public void apagar(Entity e);
	public Entity pesquisar(long id);
	public List<Entity> pesquisar(String jql);

}
