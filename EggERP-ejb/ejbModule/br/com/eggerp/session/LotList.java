package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("lotList")
public class LotList extends EntityQuery<Lot> {

	private static final String EJBQL = "select lot from Lot lot";

	private static final String[] RESTRICTIONS = {
			"lower(lot.debicking) like lower(concat(#{lotList.lot.debicking},'%'))", };

	private Lot lot = new Lot();

	public LotList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Lot getLot() {
		return lot;
	}
}
