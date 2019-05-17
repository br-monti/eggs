package br.inatel.fetin.fetindoctor.dao;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Name;

import br.inatel.fetin.fetindoctor.entity.Remedy;

@Stateful
@Name("remedyDao")
public class RemedyDaoBean extends GenericDAOBean<Remedy, Integer> implements RemedyDao, Serializable {
	private static final long serialVersionUID = -6007889310926730699L;

	public static RemedyDao getInstance() {
		return (RemedyDao) Component.getInstance("remedyDao");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Remedy> findRemedy(Remedy remedy) {
		
		Query query = createNamedQuery("findRemedy");
		query.setParameter("remedy", remedy);
		
		return (ArrayList<Remedy>) query.getResultList();
	}

	@Remove
	public void remove() {
		
	}
	
	@Destroy
	public void destroy() {
		
	}
}