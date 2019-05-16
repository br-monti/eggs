package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("productionProductHome")
public class ProductionProductHome extends EntityHome<ProductionProduct> {

	@In(create = true)
	ProductHome productHome;
	@In(create = true)
	ProductionHome productionHome;

	public void setProductionProductId(ProductionProductId id) {
		setId(id);
	}

	public ProductionProductId getProductionProductId() {
		return (ProductionProductId) getId();
	}

	public ProductionProductHome() {
		setProductionProductId(new ProductionProductId());
	}

	@Override
	public boolean isIdDefined() {
		if (getProductionProductId().getProductionId() == 0)
			return false;
		if (getProductionProductId().getProductId() == 0)
			return false;
		if (getProductionProductId().getId() == 0)
			return false;
		return true;
	}

	@Override
	protected ProductionProduct createInstance() {
		ProductionProduct productionProduct = new ProductionProduct();
		productionProduct.setId(new ProductionProductId());
		return productionProduct;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Product product = productHome.getDefinedInstance();
		if (product != null) {
			getInstance().setProduct(product);
		}
		Production production = productionHome.getDefinedInstance();
		if (production != null) {
			getInstance().setProduction(production);
		}
	}

	public boolean isWired() {
		if (getInstance().getProduct() == null)
			return false;
		if (getInstance().getProduction() == null)
			return false;
		return true;
	}

	public ProductionProduct getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
