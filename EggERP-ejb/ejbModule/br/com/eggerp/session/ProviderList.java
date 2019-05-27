package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("providerList")
public class ProviderList extends EntityQuery<Provider> {

	private static final String EJBQL = "select provider from Provider provider";

	private static final String[] RESTRICTIONS = {
			"lower(provider.provider) like lower(concat(#{providerList.provider.provider},'%'))",
			"lower(provider.cnpjCpf) like lower(concat(#{providerList.provider.cnpjCpf},'%'))",
			"lower(provider.sifIma) like lower(concat(#{providerList.provider.sifIma},'%'))",
			"lower(provider.city) like lower(concat(#{providerList.provider.city},'%'))",
			"lower(provider.state) like lower(concat(#{providerList.provider.state},'%'))",
			"lower(provider.neighborhood) like lower(concat(#{providerList.provider.neighborhood},'%'))", };

	private Provider provider = new Provider();

	public ProviderList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Provider getProvider() {
		return provider;
	}
}
