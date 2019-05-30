package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("baseEggList")
public class BaseEggList extends EntityQuery<BaseEgg> {

	private static final String EJBQL = "select baseEgg from BaseEgg baseEgg";

	private static final String[] RESTRICTIONS = {};

	private BaseEgg baseEgg = new BaseEgg();

	public BaseEggList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public BaseEgg getBaseEgg() {
		return baseEgg;
	}
}
