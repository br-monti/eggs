package br.com.egg.session;

import br.com.egg.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("productionMonitoringList")
public class ProductionMonitoringList extends EntityQuery<ProductionMonitoring> {

	private static final String EJBQL = "select productionMonitoring from ProductionMonitoring productionMonitoring";

	private static final String[] RESTRICTIONS = {};

	private ProductionMonitoring productionMonitoring = new ProductionMonitoring();

	public ProductionMonitoringList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ProductionMonitoring getProductionMonitoring() {
		return productionMonitoring;
	}
}
