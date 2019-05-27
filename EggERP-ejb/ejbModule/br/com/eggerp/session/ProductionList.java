package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("productionList")
public class ProductionList extends EntityQuery<Production> {

	private static final String EJBQL = "select production from Production production";

	private static final String[] RESTRICTIONS = {};

	private Production production = new Production();

	public ProductionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Production getProduction() {
		return production;
	}
}
