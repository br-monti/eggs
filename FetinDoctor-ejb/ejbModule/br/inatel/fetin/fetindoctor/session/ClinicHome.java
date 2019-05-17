package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("clinicHome")
public class ClinicHome extends EntityHome<Clinic> {

	public void setClinicId(Integer id) {
		setId(id);
	}

	public Integer getClinicId() {
		return (Integer) getId();
	}

	@Override
	protected Clinic createInstance() {
		Clinic clinic = new Clinic();
		return clinic;
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

	public Clinic getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Prescription> getPrescriptions() {
		return getInstance() == null ? null : new ArrayList<Prescription>(
				getInstance().getPrescriptions());
	}

}
