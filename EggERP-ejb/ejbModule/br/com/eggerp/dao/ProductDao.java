package br.com.eggerp.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import br.com.eggerp.entity.Product;




@Local
public interface ProductDao extends GenericDAO<Product, Integer> {
	
	public ArrayList<Product> findProduct(Product product);

	public void destroy();
	
	public void remove();


}
