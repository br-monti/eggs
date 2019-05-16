package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("productList")
public class ProductList extends EntityQuery<Product> {

	private static final String EJBQL = "select product from Product product";

	private static final String[] RESTRICTIONS = {
			"lower(product.product) like lower(concat(#{productList.product.product},'%'))",
			"lower(product.barcode) like lower(concat(#{productList.product.barcode},'%'))", };

	private Product product = new Product();

	public ProductList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Product getProduct() {
		return product;
	}
}
