package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("productionsHome")
public class ProductionsHome extends EntityHome<Productions> {

	@In(create = true)
	ProductHome productHome;
	@In(create = true)
	ProductionHome productionHome;

	public void setProductionsId(ProductionsId id) {
		setId(id);
	}

	public ProductionsId getProductionsId() {
		return (ProductionsId) getId();
	}

	public ProductionsHome() {
		setProductionsId(new ProductionsId());
	}

	@Override
	public boolean isIdDefined() {
		if (getProductionsId().getId() == 0)
			return false;
		if (getProductionsId().getProductId() == 0)
			return false;
		if (getProductionsId().getProductionId() == 0)
			return false;
		return true;
	}

	@Override
	protected Productions createInstance() {
		Productions productions = new Productions();
		productions.setId(new ProductionsId());
		return productions;
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

	public Productions getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ExpeditionByProductions> getExpeditionByProductionses() {
		return getInstance() == null ? null
				: new ArrayList<ExpeditionByProductions>(getInstance().getExpeditionByProductionses());
	}

}
