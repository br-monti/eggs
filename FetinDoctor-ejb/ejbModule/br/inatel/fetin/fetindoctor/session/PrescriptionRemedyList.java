package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("prescriptionRemedyList")
public class PrescriptionRemedyList extends EntityQuery<PrescriptionRemedy> {

	private static final String EJBQL = "select prescriptionRemedy from PrescriptionRemedy prescriptionRemedy";

	private static final String[] RESTRICTIONS = { "lower(prescriptionRemedy.observation) like lower(concat(#{prescriptionRemedyList.prescriptionRemedy.observation},'%'))", };

	private PrescriptionRemedy prescriptionRemedy;

	public PrescriptionRemedyList() {
		prescriptionRemedy = new PrescriptionRemedy();
		prescriptionRemedy.setId(new PrescriptionRemedyId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public PrescriptionRemedy getPrescriptionRemedy() {
		return prescriptionRemedy;
	}
}
