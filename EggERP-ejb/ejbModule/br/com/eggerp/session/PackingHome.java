package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("packingHome")
public class PackingHome extends EntityHome<Packing> {

	public void setPackingId(Integer id) {
		setId(id);
	}

	public Integer getPackingId() {
		return (Integer) getId();
	}

	@Override
	protected Packing createInstance() {
		Packing packing = new Packing();
		return packing;
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

	public Packing getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Product> getProducts() {
		return getInstance() == null ? null : new ArrayList<Product>(getInstance().getProducts());
	}

}
