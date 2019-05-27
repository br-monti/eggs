package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("colorList")
public class ColorList extends EntityQuery<Color> {

	private static final String EJBQL = "select color from Color color";

	private static final String[] RESTRICTIONS = {
			"lower(color.color) like lower(concat(#{colorList.color.color},'%'))", };

	private Color color = new Color();

	public ColorList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Color getColor() {
		return color;
	}
}
