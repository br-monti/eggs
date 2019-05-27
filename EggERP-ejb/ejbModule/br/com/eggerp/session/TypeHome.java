package br.com.eggerp.session;

import br.com.eggerp.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("typeHome")
public class TypeHome extends EntityHome<Type> {

	public void setTypeId(Integer id) {
		setId(id);
	}

	public Integer getTypeId() {
		return (Integer) getId();
	}

	@Override
	protected Type createInstance() {
		Type type = new Type();
		return type;
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

	public Type getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Product> getProducts() {
		return getInstance() == null ? null : new ArrayList<Product>(getInstance().getProducts());
	}

}
