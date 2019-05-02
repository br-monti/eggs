package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("treatmentHourHome")
public class TreatmentHourHome extends EntityHome<TreatmentHour> {

	@In(create = true)
	PrescriptionRemedyHome prescriptionRemedyHome;

	public void setTreatmentHourId(Integer id) {
		setId(id);
	}

	public Integer getTreatmentHourId() {
		return (Integer) getId();
	}

	@Override
	protected TreatmentHour createInstance() {
		TreatmentHour treatmentHour = new TreatmentHour();
		return treatmentHour;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		PrescriptionRemedy prescriptionRemedy = prescriptionRemedyHome
				.getDefinedInstance();
		if (prescriptionRemedy != null) {
			getInstance().setPrescriptionRemedy(prescriptionRemedy);
		}
	}

	public boolean isWired() {
		if (getInstance().getPrescriptionRemedy() == null)
			return false;
		return true;
	}

	public TreatmentHour getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
