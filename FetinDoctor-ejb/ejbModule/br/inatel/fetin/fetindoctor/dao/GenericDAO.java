package br.inatel.fetin.fetindoctor.dao;

import java.util.Collection;

import javax.ejb.ObjectNotFoundException;
import javax.persistence.EntityManager;

public interface GenericDAO<Entity, PK> {
	
	public EntityManager getEntityManager();

	public void insert(Entity entity);
	
	public void delete(Entity entity);
	
	public Entity update(Entity entity);
	
	public Entity refreshEntity(Entity entity);
	
	public Collection<Entity> findAll();
	
	public Entity findByPK(PK pk) throws ObjectNotFoundException;
	
	public Collection<Entity> findAllByEnableStatus(boolean enabled);

}

