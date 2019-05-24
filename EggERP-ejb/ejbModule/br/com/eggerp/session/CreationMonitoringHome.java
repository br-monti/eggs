package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("creationMonitoringHome")
public class CreationMonitoringHome extends EntityHome<CreationMonitoring> {

	@In(create = true)
	LotHome lotHome;

	public void setCreationMonitoringId(Integer id) {
		setId(id);
	}

	public Integer getCreationMonitoringId() {
		return (Integer) getId();
	}

	@Override
	protected CreationMonitoring createInstance() {
		CreationMonitoring creationMonitoring = new CreationMonitoring();
		return creationMonitoring;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Lot lot = lotHome.getDefinedInstance();
		if (lot != null) {
			getInstance().setLot(lot);
		}
	}

	public boolean isWired() {
		if (getInstance().getLot() == null)
			return false;
		return true;
	}

	public CreationMonitoring getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
