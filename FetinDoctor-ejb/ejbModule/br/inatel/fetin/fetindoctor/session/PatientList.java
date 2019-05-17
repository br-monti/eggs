package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("patientList")
public class PatientList extends EntityQuery<Patient> {

	private static final String EJBQL = "select patient from Patient patient";

	private static final String[] RESTRICTIONS = {
			"lower(patient.name) like lower(concat(#{patientList.patient.name},'%'))",
			"lower(patient.address) like lower(concat(#{patientList.patient.address},'%'))",
			"lower(patient.sex) like lower(concat(#{patientList.patient.sex},'%'))",
			"lower(patient.district) like lower(concat(#{patientList.patient.district},'%'))",
			"lower(patient.city) like lower(concat(#{patientList.patient.city},'%'))",
			"lower(patient.state) like lower(concat(#{patientList.patient.state},'%'))",
			"lower(patient.phone) like lower(concat(#{patientList.patient.phone},'%'))",
			"lower(patient.cellphone) like lower(concat(#{patientList.patient.cellphone},'%'))",
			"lower(patient.email) like lower(concat(#{patientList.patient.email},'%'))", };

	private Patient patient = new Patient();

	public PatientList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Patient getPatient() {
		return patient;
	}
}
