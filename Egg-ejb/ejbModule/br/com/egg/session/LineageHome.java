package br.com.egg.session;

import br.com.egg.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("lineageHome")
public class LineageHome extends EntityHome<Lineage> {

	public void setLineageId(Integer id) {
		setId(id);
	}

	public Integer getLineageId() {
		return (Integer) getId();
	}

	@Override
	protected Lineage createInstance() {
		Lineage lineage = new Lineage();
		return lineage;
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

	public Lineage getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Lot> getLots() {
		return getInstance() == null ? null : new ArrayList<Lot>(getInstance().getLots());
	}

}
