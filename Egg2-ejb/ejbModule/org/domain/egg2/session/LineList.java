package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("lineList")
public class LineList extends EntityQuery<Line> {

	private static final String EJBQL = "select line from Line line";

	private static final String[] RESTRICTIONS = { "lower(line.line) like lower(concat(#{lineList.line.line},'%'))",
			"lower(line.cities) like lower(concat(#{lineList.line.cities},'%'))", };

	private Line line = new Line();

	public LineList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Line getLine() {
		return line;
	}
}
