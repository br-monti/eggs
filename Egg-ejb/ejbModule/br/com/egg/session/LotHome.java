package br.com.egg.session;

import br.com.egg.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("lotHome")
public class LotHome extends EntityHome<Lot> {

	@In(create = true)
	LineageHome lineageHome;
	@In(create = true)
	ShedHome shedHome;

	public void setLotId(Integer id) {
		setId(id);
	}

	public Integer getLotId() {
		return (Integer) getId();
	}

	@Override
	protected Lot createInstance() {
		Lot lot = new Lot();
		return lot;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Lineage lineage = lineageHome.getDefinedInstance();
		if (lineage != null) {
			getInstance().setLineage(lineage);
		}
		Shed shed = shedHome.getDefinedInstance();
		if (shed != null) {
			getInstance().setShed(shed);
		}
	}

	public boolean isWired() {
		if (getInstance().getLineage() == null)
			return false;
		if (getInstance().getShed() == null)
			return false;
		return true;
	}

	public Lot getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<CreationMonitoring> getCreationMonitorings() {
		return getInstance() == null ? null : new ArrayList<CreationMonitoring>(getInstance().getCreationMonitorings());
	}

	public List<ProductionMonitoring> getProductionMonitorings() {
		return getInstance() == null ? null
				: new ArrayList<ProductionMonitoring>(getInstance().getProductionMonitorings());
	}

}
