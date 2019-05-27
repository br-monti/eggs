package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("expeditionByProductionsList")
public class ExpeditionByProductionsList extends EntityQuery<ExpeditionByProductions> {

	private static final String EJBQL = "select expeditionByProductions from ExpeditionByProductions expeditionByProductions";

	private static final String[] RESTRICTIONS = {};

	private ExpeditionByProductions expeditionByProductions;

	public ExpeditionByProductionsList() {
		expeditionByProductions = new ExpeditionByProductions();
		expeditionByProductions.setId(new ExpeditionByProductionsId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ExpeditionByProductions getExpeditionByProductions() {
		return expeditionByProductions;
	}
}
