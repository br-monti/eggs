package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("lineHome")
public class LineHome extends EntityHome<Line> {

	public void setLineId(Integer id) {
		setId(id);
	}

	public Integer getLineId() {
		return (Integer) getId();
	}

	@Override
	protected Line createInstance() {
		Line line = new Line();
		return line;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Line getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Expedition> getExpeditions() {
		return getInstance() == null ? null : new ArrayList<Expedition>(getInstance().getExpeditions());
	}

}
