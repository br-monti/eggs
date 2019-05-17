package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("remedyList")
public class RemedyList extends EntityQuery<Remedy> {

	private static final String EJBQL = "select remedy from Remedy remedy";

	private static final String[] RESTRICTIONS = {
			"lower(remedy.name) like lower(concat(#{remedyList.remedy.name},'%'))",
			"lower(remedy.form) like lower(concat(#{remedyList.remedy.form},'%'))",
			"lower(remedy.concentration) like lower(concat(#{remedyList.remedy.concentration},'%'))",
			"lower(remedy.laboratory) like lower(concat(#{remedyList.remedy.laboratory},'%'))", };

	private Remedy remedy = new Remedy();

	public RemedyList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Remedy getRemedy() {
		return remedy;
	}
}
