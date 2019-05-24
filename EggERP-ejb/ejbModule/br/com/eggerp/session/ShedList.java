package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("shedList")
public class ShedList extends EntityQuery<Shed> {

	private static final String EJBQL = "select shed from Shed shed";

	private static final String[] RESTRICTIONS = { "lower(shed.name) like lower(concat(#{shedList.shed.name},'%'))",
			"lower(shed.type) like lower(concat(#{shedList.shed.type},'%'))",
			"lower(shed.model) like lower(concat(#{shedList.shed.model},'%'))", };

	private Shed shed = new Shed();

	public ShedList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Shed getShed() {
		return shed;
	}
}
