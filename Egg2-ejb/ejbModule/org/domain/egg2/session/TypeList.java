package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("typeList")
public class TypeList extends EntityQuery<Type> {

	private static final String EJBQL = "select type from Type type";

	private static final String[] RESTRICTIONS = { "lower(type.type) like lower(concat(#{typeList.type.type},'%'))", };

	private Type type = new Type();

	public TypeList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Type getType() {
		return type;
	}
}
