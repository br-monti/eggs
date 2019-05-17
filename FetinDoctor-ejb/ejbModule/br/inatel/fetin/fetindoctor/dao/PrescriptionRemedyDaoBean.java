package br.inatel.fetin.fetindoctor.dao;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Name;

import br.inatel.fetin.fetindoctor.entity.PrescriptionRemedy;
import br.inatel.fetin.fetindoctor.entity.Remedy;

@Stateful
@Name("prescriptionRemedyDao")
public class PrescriptionRemedyDaoBean extends GenericDAOBean<PrescriptionRemedy, Integer> implements PrescriptionRemedyDao, Serializable {
	

	private static final long serialVersionUID = 2842262534480200167L;

	public static PrescriptionRemedyDao getInstance() {
		return (PrescriptionRemedyDao) Component.getInstance("prescriptionRemedyDao");
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
