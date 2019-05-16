package org.domain.egg2.dao;

import java.util.ArrayList;

import javax.ejb.Local;

import org.domain.egg2.entity.Production;

@Local
public interface ProductionDao extends GenericDAO<Production, Integer> {
	
	public ArrayList<Production> findProduction(Production production);

	public void destroy();
	
	public void remove();

}
