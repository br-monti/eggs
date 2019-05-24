package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("lineageList")
public class LineageList extends EntityQuery<Lineage> {

	private static final String EJBQL = "select lineage from Lineage lineage";

	private static final String[] RESTRICTIONS = {
			"lower(lineage.lineage) like lower(concat(#{lineageList.lineage.lineage},'%'))",
			"lower(lineage.color) like lower(concat(#{lineageList.lineage.color},'%'))", };

	private Lineage lineage = new Lineage();

	public LineageList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Lineage getLineage() {
		return lineage;
	}
}
