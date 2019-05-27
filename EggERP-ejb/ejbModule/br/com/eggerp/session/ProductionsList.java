package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("productionsList")
public class ProductionsList extends EntityQuery<Productions> {

	private static final String EJBQL = "select productions from Productions productions";

	private static final String[] RESTRICTIONS = {};

	private Productions productions;

	public ProductionsList() {
		productions = new Productions();
		productions.setId(new ProductionsId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Productions getProductions() {
		return productions;
	}
}
