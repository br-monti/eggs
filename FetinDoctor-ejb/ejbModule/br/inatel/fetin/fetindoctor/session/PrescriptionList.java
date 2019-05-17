package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("prescriptionList")
public class PrescriptionList extends EntityQuery<Prescription> {

	private static final String EJBQL = "select prescription from Prescription prescription";

	private static final String[] RESTRICTIONS = { "lower(prescription.accessCode) like lower(concat(#{prescriptionList.prescription.accessCode},'%'))", };

	private Prescription prescription = new Prescription();

	public PrescriptionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Prescription getPrescription() {
		return prescription;
	}
}
