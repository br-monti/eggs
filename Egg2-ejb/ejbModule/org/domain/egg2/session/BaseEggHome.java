package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("baseEggHome")
public class BaseEggHome extends EntityHome<BaseEgg> {

	@In(create = true)
	ColorHome colorHome;

	public void setBaseEggId(Integer id) {
		setId(id);
	}

	public Integer getBaseEggId() {
		return (Integer) getId();
	}

	@Override
	protected BaseEgg createInstance() {
		BaseEgg baseEgg = new BaseEgg();
		return baseEgg;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Color color = colorHome.getDefinedInstance();
		if (color != null) {
			getInstance().setColor(color);
		}
	}

	public boolean isWired() {
		if (getInstance().getColor() == null)
			return false;
		return true;
	}

	public BaseEgg getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Production> getProductions() {
		return getInstance() == null ? null : new ArrayList<Production>(getInstance().getProductions());
	}

}
