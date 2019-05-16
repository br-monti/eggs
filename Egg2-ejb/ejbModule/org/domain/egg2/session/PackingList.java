package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("packingList")
public class PackingList extends EntityQuery<Packing> {

	private static final String EJBQL = "select packing from Packing packing";

	private static final String[] RESTRICTIONS = {
			"lower(packing.packing) like lower(concat(#{packingList.packing.packing},'%'))", };

	private Packing packing = new Packing();

	public PackingList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Packing getPacking() {
		return packing;
	}
}
