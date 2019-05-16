package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("productHome")
public class ProductHome extends EntityHome<Product> {

	@In(create = true)
	PackingHome packingHome;
	@In(create = true)
	ColorHome colorHome;
	@In(create = true)
	TypeHome typeHome;

	public void setProductId(Integer id) {
		setId(id);
	}

	public Integer getProductId() {
		return (Integer) getId();
	}

	@Override
	protected Product createInstance() {
		Product product = new Product();
		return product;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Packing packing = packingHome.getDefinedInstance();
		if (packing != null) {
			getInstance().setPacking(packing);
		}
		Color color = colorHome.getDefinedInstance();
		if (color != null) {
			getInstance().setColor(color);
		}
		Type type = typeHome.getDefinedInstance();
		if (type != null) {
			getInstance().setType(type);
		}
	}

	public boolean isWired() {
		if (getInstance().getPacking() == null)
			return false;
		if (getInstance().getColor() == null)
			return false;
		if (getInstance().getType() == null)
			return false;
		return true;
	}

	public Product getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ProductionProduct> getProductionProducts() {
		return getInstance() == null ? null : new ArrayList<ProductionProduct>(getInstance().getProductionProducts());
	}

}
