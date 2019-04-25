package br.com.egg.session;

import br.com.egg.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("productionMonitoringHome")
public class ProductionMonitoringHome extends EntityHome<ProductionMonitoring> {

	@In(create = true)
	LotHome lotHome;

	public void setProductionMonitoringId(Integer id) {
		setId(id);
	}

	public Integer getProductionMonitoringId() {
		return (Integer) getId();
	}

	@Override
	protected ProductionMonitoring createInstance() {
		ProductionMonitoring productionMonitoring = new ProductionMonitoring();
		return productionMonitoring;
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

	public ProductionMonitoring getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
