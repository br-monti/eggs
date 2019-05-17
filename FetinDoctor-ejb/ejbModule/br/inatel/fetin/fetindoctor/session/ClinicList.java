package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("clinicList")
public class ClinicList extends EntityQuery<Clinic> {

	private static final String EJBQL = "select clinic from Clinic clinic";

	private static final String[] RESTRICTIONS = {
			"lower(clinic.name) like lower(concat(#{clinicList.clinic.name},'%'))",
			"lower(clinic.address) like lower(concat(#{clinicList.clinic.address},'%'))",
			"lower(clinic.district) like lower(concat(#{clinicList.clinic.district},'%'))",
			"lower(clinic.city) like lower(concat(#{clinicList.clinic.city},'%'))",
			"lower(clinic.state) like lower(concat(#{clinicList.clinic.state},'%'))",
			"lower(clinic.phone) like lower(concat(#{clinicList.clinic.phone},'%'))",
			"lower(clinic.cnpj) like lower(concat(#{clinicList.clinic.cnpj},'%'))", };

	private Clinic clinic = new Clinic();

	public ClinicList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Clinic getClinic() {
		return clinic;
	}
}
