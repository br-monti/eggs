package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("packingList")
public class PackingList extends EntityQuery<Packing> {

	private static final String EJBQL = "select packing from Packing packing";

	private static final String[] RESTRICTIONS = {
			"lower(packing.packing) like lower(concat(#{packingList.packing.packing},'%'))",
			"lower(packing.type) like lower(concat(#{packingList.packing.type},'%'))", };

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
