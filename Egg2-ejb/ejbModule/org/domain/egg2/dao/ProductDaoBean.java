package org.domain.egg2.dao;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.Query;

import org.domain.egg2.entity.Product;
import org.jboss.seam.Component;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Name;


@Stateful
@Name("productDao")
public class ProductDaoBean extends GenericDAOBean<Product, Integer> implements ProductDao, Serializable {
	private static final long serialVersionUID = -6007889310926730699L;

	public static ProductDao getInstance() {
		return (ProductDao) Component.getInstance("productDao");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Product> findProduct(Product product) {
		
		Query query = createNamedQuery("findProduct");
		query.setParameter("product", product);
		
		return (ArrayList<Product>) query.getResultList();
	}

	@Remove
	public void remove() {
		
	}
	
	@Destroy
	public void destroy() {
		
	}
}