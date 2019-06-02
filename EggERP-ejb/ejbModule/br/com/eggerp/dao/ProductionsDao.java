package br.com.eggerp.dao;

import java.util.ArrayList;

import javax.ejb.Local;
import br.com.eggerp.entity.Product;
import br.com.eggerp.entity.Productions;
@Local
public interface ProductionsDao extends GenericDAO<Productions, Integer> {
	
	public ArrayList<Product> findProduct(Product product);

	public void destroy();
	
	public void remove();

}
