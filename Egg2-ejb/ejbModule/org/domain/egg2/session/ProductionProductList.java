package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("productionProductList")
public class ProductionProductList extends EntityQuery<ProductionProduct> {

	private static final String EJBQL = "select productionProduct from ProductionProduct productionProduct";

	private static final String[] RESTRICTIONS = {};

	private ProductionProduct productionProduct;

	public ProductionProductList() {
		productionProduct = new ProductionProduct();
		productionProduct.setId(new ProductionProductId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ProductionProduct getProductionProduct() {
		return productionProduct;
	}
}
