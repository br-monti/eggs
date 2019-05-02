package br.inatel.fetin.fetindoctor.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import br.inatel.fetin.fetindoctor.entity.Prescription;
import br.inatel.fetin.fetindoctor.entity.Remedy;


@Local
public interface RemedyDao extends GenericDAO<Remedy, Integer> {
	
	public ArrayList<Remedy> findRemedy(Remedy remedy);

	public void destroy();
	
	public void remove();


}
