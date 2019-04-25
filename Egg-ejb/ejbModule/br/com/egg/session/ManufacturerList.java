package br.com.egg.session;

import br.com.egg.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("manufacturerList")
public class ManufacturerList extends EntityQuery<Manufacturer> {

	private static final String EJBQL = "select manufacturer from Manufacturer manufacturer";

	private static final String[] RESTRICTIONS = {
			"lower(manufacturer.manufacturer) like lower(concat(#{manufacturerList.manufacturer.manufacturer},'%'))", };

	private Manufacturer manufacturer = new Manufacturer();

	public ManufacturerList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}
}
