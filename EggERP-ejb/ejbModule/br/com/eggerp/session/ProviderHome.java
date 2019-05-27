package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("providerHome")
public class ProviderHome extends EntityHome<Provider> {

	public void setProviderId(Integer id) {
		setId(id);
	}

	public Integer getProviderId() {
		return (Integer) getId();
	}

	@Override
	protected Provider createInstance() {
		Provider provider = new Provider();
		return provider;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Provider getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<BaseEgg> getBaseEggs() {
		return getInstance() == null ? null : new ArrayList<BaseEgg>(getInstance().getBaseEggs());
	}

}
