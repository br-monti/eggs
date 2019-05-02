package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("doctorHome")
public class DoctorHome extends EntityHome<Doctor> {

	public void setDoctorId(Integer id) {
		setId(id);
	}

	public Integer getDoctorId() {
		return (Integer) getId();
	}

	@Override
	protected Doctor createInstance() {
		Doctor doctor = new Doctor();
		return doctor;
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

	public Doctor getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Prescription> getPrescriptions() {
		return getInstance() == null ? null : new ArrayList<Prescription>(
				getInstance().getPrescriptions());
	}

}
