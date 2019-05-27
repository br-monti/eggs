package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("productionHome")
public class ProductionHome extends EntityHome<Production> {

	@In(create = true)
	BaseEggHome baseEggHome;

	public void setProductionId(Integer id) {
		setId(id);
	}

	public Integer getProductionId() {
		return (Integer) getId();
	}

	@Override
	protected Production createInstance() {
		Production production = new Production();
		return production;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		BaseEgg baseEgg = baseEggHome.getDefinedInstance();
		if (baseEgg != null) {
			getInstance().setBaseEgg(baseEgg);
		}
	}

	public boolean isWired() {
		if (getInstance().getBaseEgg() == null)
			return false;
		return true;
	}

	public Production getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Productions> getProductionses() {
		return getInstance() == null ? null : new ArrayList<Productions>(getInstance().getProductionses());
	}

}
