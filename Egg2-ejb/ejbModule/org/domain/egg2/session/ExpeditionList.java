package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("expeditionList")
public class ExpeditionList extends EntityQuery<Expedition> {

	private static final String EJBQL = "select expedition from Expedition expedition";

	private static final String[] RESTRICTIONS = {};

	private Expedition expedition = new Expedition();

	public ExpeditionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Expedition getExpedition() {
		return expedition;
	}
}
