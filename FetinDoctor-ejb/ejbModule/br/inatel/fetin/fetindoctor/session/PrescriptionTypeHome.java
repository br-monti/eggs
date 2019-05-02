package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("prescriptionTypeHome")
public class PrescriptionTypeHome extends EntityHome<PrescriptionType> {

	public void setPrescriptionTypeId(Integer id) {
		setId(id);
	}

	public Integer getPrescriptionTypeId() {
		return (Integer) getId();
	}

	@Override
	protected PrescriptionType createInstance() {
		PrescriptionType prescriptionType = new PrescriptionType();
		return prescriptionType;
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

	public PrescriptionType getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Prescription> getPrescriptions() {
		return getInstance() == null ? null : new ArrayList<Prescription>(
				getInstance().getPrescriptions());
	}

}
