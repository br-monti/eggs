package br.com.eggerp.dao;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Name;

import br.com.eggerp.entity.Production;


@Stateful
@Name("productionDao")
public class ProductionDaoBean extends GenericDAOBean<Production, Integer> implements ProductionDao, Serializable {
	
	
	private static final long serialVersionUID = -6007889310926730699L;

	public static ProductionDao getInstance() {
		return (ProductionDao) Component.getInstance("productionDao");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Production> findProduction(Production production) {
		
		Query query = createNamedQuery("findProduction");
		query.setParameter("production", production);
		
		return (ArrayList<Production>) query.getResultList();
	}

	@Remove
	public void remove() {
		
	}
	
	@Destroy
	public void destroy() {
		
	}


}

