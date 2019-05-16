package org.domain.egg2.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import org.domain.egg2.entity.Product;



@Local
public interface ProductDao extends GenericDAO<Product, Integer> {
	
	public ArrayList<Product> findProduct(Product product);

	public void destroy();
	
	public void remove();


}
