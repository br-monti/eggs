package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("prescriptionRemedyHome")
public class PrescriptionRemedyHome extends EntityHome<PrescriptionRemedy> {

	@In(create = true)
	PrescriptionHome prescriptionHome;
	@In(create = true)
	RemedyHome remedyHome;

	public void setPrescriptionRemedyId(PrescriptionRemedyId id) {
		setId(id);
	}

	public PrescriptionRemedyId getPrescriptionRemedyId() {
		return (PrescriptionRemedyId) getId();
	}

	public PrescriptionRemedyHome() {
		setPrescriptionRemedyId(new PrescriptionRemedyId());
	}

	@Override
	public boolean isIdDefined() {
		if (getPrescriptionRemedyId().getId() == 0)
			return false;
		if (getPrescriptionRemedyId().getPrescriptionId() == 0)
			return false;
		if (getPrescriptionRemedyId().getRemedyId() == 0)
			return false;
		return true;
	}

	@Override
	protected PrescriptionRemedy createInstance() {
		PrescriptionRemedy prescriptionRemedy = new PrescriptionRemedy();
		prescriptionRemedy.setId(new PrescriptionRemedyId());
		return prescriptionRemedy;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Prescription prescription = prescriptionHome.getDefinedInstance();
		if (prescription != null) {
			getInstance().setPrescription(prescription);
		}
		Remedy remedy = remedyHome.getDefinedInstance();
		if (remedy != null) {
			getInstance().setRemedy(remedy);
		}
	}

	public boolean isWired() {
		if (getInstance().getPrescription() == null)
			return false;
		if (getInstance().getRemedy() == null)
			return false;
		return true;
	}

	public PrescriptionRemedy getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<TreatmentHour> getTreatmentHours() {
		return getInstance() == null ? null : new ArrayList<TreatmentHour>(
				getInstance().getTreatmentHours());
	}

}
