package br.inatel.fetin.fetindoctor.dao;

import java.util.ArrayList;

import javax.ejb.Local;

import br.inatel.fetin.fetindoctor.entity.Prescription;

@Local
public interface PrescriptionDao extends GenericDAO<Prescription, Integer> {
	
	public ArrayList<Prescription> findPrescription(Prescription prescription);

	public void destroy();
	
	public void remove();

}
