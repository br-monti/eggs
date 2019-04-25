package br.com.egg.session;

import br.com.egg.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("shedHome")
public class ShedHome extends EntityHome<Shed> {

	@In(create = true)
	ManufacturerHome manufacturerHome;

	public void setShedId(Integer id) {
		setId(id);
	}

	public Integer getShedId() {
		return (Integer) getId();
	}

	@Override
	protected Shed createInstance() {
		Shed shed = new Shed();
		return shed;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Manufacturer manufacturer = manufacturerHome.getDefinedInstance();
		if (manufacturer != null) {
			getInstance().setManufacturer(manufacturer);
		}
	}

	public boolean isWired() {
		if (getInstance().getManufacturer() == null)
			return false;
		return true;
	}

	public Shed getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Lot> getLots() {
		return getInstance() == null ? null : new ArrayList<Lot>(getInstance().getLots());
	}

}
