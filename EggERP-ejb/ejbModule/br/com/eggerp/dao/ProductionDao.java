package br.com.eggerp.dao;

import java.util.ArrayList;

import javax.ejb.Local;

import br.com.eggerp.entity.Production;


@Local
public interface ProductionDao extends GenericDAO<Production, Integer> {
	
	public ArrayList<Production> findProduction(Production production);

	public void destroy();
	
	public void remove();

}
