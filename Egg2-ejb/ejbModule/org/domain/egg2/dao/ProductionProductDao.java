package org.domain.egg2.dao;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Remove;

import org.domain.egg2.entity.Product;
import org.domain.egg2.entity.ProductionProduct;
import org.jboss.seam.annotations.Destroy;
@Local
public interface ProductionProductDao extends GenericDAO<ProductionProduct, Integer> {
	
	public ArrayList<Product> findProduct(Product product);

	public void destroy();
	
	public void remove();

}
