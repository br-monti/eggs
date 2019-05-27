package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("expeditionByProductionsHome")
public class ExpeditionByProductionsHome extends EntityHome<ExpeditionByProductions> {

	@In(create = true)
	ProductionsHome productionsHome;
	@In(create = true)
	ExpeditionHome expeditionHome;

	public void setExpeditionByProductionsId(ExpeditionByProductionsId id) {
		setId(id);
	}

	public ExpeditionByProductionsId getExpeditionByProductionsId() {
		return (ExpeditionByProductionsId) getId();
	}

	public ExpeditionByProductionsHome() {
		setExpeditionByProductionsId(new ExpeditionByProductionsId());
	}

	@Override
	public boolean isIdDefined() {
		if (getExpeditionByProductionsId().getId() == 0)
			return false;
		if (getExpeditionByProductionsId().getExpeditionId() == 0)
			return false;
		if (getExpeditionByProductionsId().getProductionsId() == 0)
			return false;
		if (getExpeditionByProductionsId().getProductionsProductId() == 0)
			return false;
		if (getExpeditionByProductionsId().getProductionsProductionId() == 0)
			return false;
		return true;
	}

	@Override
	protected ExpeditionByProductions createInstance() {
		ExpeditionByProductions expeditionByProductions = new ExpeditionByProductions();
		expeditionByProductions.setId(new ExpeditionByProductionsId());
		return expeditionByProductions;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Productions productions = productionsHome.getDefinedInstance();
		if (productions != null) {
			getInstance().setProductions(productions);
		}
		Expedition expedition = expeditionHome.getDefinedInstance();
		if (expedition != null) {
			getInstance().setExpedition(expedition);
		}
	}

	public boolean isWired() {
		if (getInstance().getProductions() == null)
			return false;
		if (getInstance().getExpedition() == null)
			return false;
		return true;
	}

	public ExpeditionByProductions getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
