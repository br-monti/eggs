package br.inatel.fetin.fetindoctor.dao;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Name;

import br.inatel.fetin.fetindoctor.entity.Prescription;

@Stateful
@Name("prescriptionDao")
public class PrescriptionDaoBean extends GenericDAOBean<Prescription, Integer> implements PrescriptionDao, Serializable {
	
	
	private static final long serialVersionUID = -6007889310926730699L;

	public static PrescriptionDao getInstance() {
		return (PrescriptionDao) Component.getInstance("prescriptionDao");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Prescription> findPrescription(Prescription prescription) {
		
		Query query = createNamedQuery("findPrescription");
		query.setParameter("prescription", prescription);
		
		return (ArrayList<Prescription>) query.getResultList();
	}

	@Remove
	public void remove() {
		
	}
	
	@Destroy
	public void destroy() {
		
	}

}

