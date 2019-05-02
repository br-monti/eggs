package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("treatmentHourList")
public class TreatmentHourList extends EntityQuery<TreatmentHour> {

	private static final String EJBQL = "select treatmentHour from TreatmentHour treatmentHour";

	private static final String[] RESTRICTIONS = {};

	private TreatmentHour treatmentHour = new TreatmentHour();

	public TreatmentHourList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TreatmentHour getTreatmentHour() {
		return treatmentHour;
	}
}
