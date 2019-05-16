package org.domain.egg2.dao;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.Query;

import org.domain.egg2.entity.Product;
import org.domain.egg2.entity.ProductionProduct;
import org.jboss.seam.Component;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Name;

@Stateful
@Name("productionProductDao")
public class ProductionProductDaoBean extends GenericDAOBean<ProductionProduct, Integer> implements ProductionProductDao, Serializable {
	

	private static final long serialVersionUID = 2842262534480200167L;

	public static ProductionProductDao getInstance() {
		return (ProductionProductDao) Component.getInstance("productionProductDao");
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
