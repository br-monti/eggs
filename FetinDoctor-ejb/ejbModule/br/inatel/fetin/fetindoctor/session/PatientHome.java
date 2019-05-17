package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("patientHome")
public class PatientHome extends EntityHome<Patient> {

	public void setPatientId(Integer id) {
		setId(id);
	}

	public Integer getPatientId() {
		return (Integer) getId();
	}

	@Override
	protected Patient createInstance() {
		Patient patient = new Patient();
		return patient;
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

	public Patient getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Prescription> getPrescriptions() {
		return getInstance() == null ? null : new ArrayList<Prescription>(
				getInstance().getPrescriptions());
	}

}
