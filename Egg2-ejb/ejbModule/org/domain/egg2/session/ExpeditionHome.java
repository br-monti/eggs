package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("expeditionHome")
public class ExpeditionHome extends EntityHome<Expedition> {

	@In(create = true)
	LineHome lineHome;

	public void setExpeditionId(Integer id) {
		setId(id);
	}

	public Integer getExpeditionId() {
		return (Integer) getId();
	}

	@Override
	protected Expedition createInstance() {
		Expedition expedition = new Expedition();
		return expedition;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Line line = lineHome.getDefinedInstance();
		if (line != null) {
			getInstance().setLine(line);
		}
	}

	public boolean isWired() {
		if (getInstance().getLine() == null)
			return false;
		return true;
	}

	public Expedition getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
