package br.inatel.fetin.fetindoctor.dao;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Remove;

import org.jboss.seam.annotations.Destroy;

import br.inatel.fetin.fetindoctor.entity.Prescription;
import br.inatel.fetin.fetindoctor.entity.PrescriptionRemedy;
import br.inatel.fetin.fetindoctor.entity.Remedy;

@Local
public interface PrescriptionRemedyDao extends GenericDAO<PrescriptionRemedy, Integer> {
	
	public ArrayList<Remedy> findRemedy(Remedy remedy);

	public void destroy();
	
	public void remove();

}
