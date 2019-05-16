package org.domain.egg2.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.ejb.ObjectNotFoundException;
import javax.persistence.Query;

//import javax.ejb.ObjectNotFoundException;
//import javax.persistence.Query;

import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.framework.EntityController;

public class GenericDAOBean<Entity, PK> extends EntityController {
	private static final long serialVersionUID = -6834307145880528379L;
	
	private Class<Entity> _persistentClass = null;
	
	@SuppressWarnings("unchecked")
	public GenericDAOBean() {
		_persistentClass = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Transactional
	public void insert(Entity entity) {
		getEntityManager().joinTransaction();
		persist(entity);
		getEntityManager().flush();
	}

	@Transactional
	public Entity update(Entity entity) {
		getEntityManager().joinTransaction();
		Entity result = merge(entity);
		getEntityManager().flush();

		return result;
	}
	
	@Transactional
	public void delete(Entity entity) {
		getEntityManager().joinTransaction();
		remove(entity);
		getEntityManager().flush();
	}

	
	@Transactional
	public Entity refreshEntity(Entity entity) {
		getEntityManager().joinTransaction();
		Entity result = merge(entity);
		refresh(result);
		getEntityManager().flush();
		return result;
	}
	
	public Entity findByPK(PK pk) throws ObjectNotFoundException {
		Entity result = null;
		
		result = find(_persistentClass, pk);
		
		if(result == null) {
			throw new ObjectNotFoundException();
		}
			
		return result;	
	}

	@SuppressWarnings("unchecked")
	public Collection<Entity> findAll() {
		return createQuery("FROM " + _persistentClass.getName() + " WHERE enabled = TRUE").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Entity> findAllByEnableStatus(boolean enabled) {
		Query query = createQuery(
			"FROM " + _persistentClass.getName() + 
			" WHERE enabled = :enabled"
		);
		query.setParameter("enabled", enabled);
		return query.getResultList();
	}
	
}

