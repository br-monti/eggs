package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("doctorList")
public class DoctorList extends EntityQuery<Doctor> {

	private static final String EJBQL = "select doctor from Doctor doctor";

	private static final String[] RESTRICTIONS = {
			"lower(doctor.name) like lower(concat(#{doctorList.doctor.name},'%'))",
			"lower(doctor.crm) like lower(concat(#{doctorList.doctor.crm},'%'))",
			"lower(doctor.speciality) like lower(concat(#{doctorList.doctor.speciality},'%'))",
			"lower(doctor.cpf) like lower(concat(#{doctorList.doctor.cpf},'%'))",
			"lower(doctor.phone) like lower(concat(#{doctorList.doctor.phone},'%'))",
			"lower(doctor.cellphone) like lower(concat(#{doctorList.doctor.cellphone},'%'))",
			"lower(doctor.email) like lower(concat(#{doctorList.doctor.email},'%'))", };

	private Doctor doctor = new Doctor();

	public DoctorList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Doctor getDoctor() {
		return doctor;
	}
}
