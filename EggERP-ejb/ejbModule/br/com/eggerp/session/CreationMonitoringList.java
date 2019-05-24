package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("creationMonitoringList")
public class CreationMonitoringList extends EntityQuery<CreationMonitoring> {

	private static final String EJBQL = "select creationMonitoring from CreationMonitoring creationMonitoring";

	private static final String[] RESTRICTIONS = {};

	private CreationMonitoring creationMonitoring = new CreationMonitoring();

	public CreationMonitoringList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public CreationMonitoring getCreationMonitoring() {
		return creationMonitoring;
	}
}
