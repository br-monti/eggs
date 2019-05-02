package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("prescriptionTypeList")
public class PrescriptionTypeList extends EntityQuery<PrescriptionType> {

	private static final String EJBQL = "select prescriptionType from PrescriptionType prescriptionType";

	private static final String[] RESTRICTIONS = {
			"lower(prescriptionType.notificationType) like lower(concat(#{prescriptionTypeList.prescriptionType.notificationType},'%'))",
			"lower(prescriptionType.lists) like lower(concat(#{prescriptionTypeList.prescriptionType.lists},'%'))",
			"lower(prescriptionType.remedyType) like lower(concat(#{prescriptionTypeList.prescriptionType.remedyType},'%'))",
			"lower(prescriptionType.color) like lower(concat(#{prescriptionTypeList.prescriptionType.color},'%'))",
			"lower(prescriptionType.validity) like lower(concat(#{prescriptionTypeList.prescriptionType.validity},'%'))", };

	private PrescriptionType prescriptionType = new PrescriptionType();

	public PrescriptionTypeList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public PrescriptionType getPrescriptionType() {
		return prescriptionType;
	}
}
