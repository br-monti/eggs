package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("manufacturerHome")
public class ManufacturerHome extends EntityHome<Manufacturer> {

	public void setManufacturerId(Integer id) {
		setId(id);
	}

	public Integer getManufacturerId() {
		return (Integer) getId();
	}

	@Override
	protected Manufacturer createInstance() {
		Manufacturer manufacturer = new Manufacturer();
		return manufacturer;
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

	public Manufacturer getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Shed> getSheds() {
		return getInstance() == null ? null : new ArrayList<Shed>(getInstance().getSheds());
	}

}
