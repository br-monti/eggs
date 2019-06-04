package br.com.eggerp.dao;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.Query;


import org.jboss.seam.Component;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Name;

import br.com.eggerp.entity.Product;
import br.com.eggerp.entity.Productions;

@Stateful
@Name("productionsDao")
public class ProductionsDaoBean extends GenericDAOBean<Productions, Integer> implements ProductionsDao, Serializable {
	

	private static final long serialVersionUID = 2842262534480200167L;

	public static ProductionsDao getInstance() {
		return (ProductionsDao) Component.getInstance("productionsDao");
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
