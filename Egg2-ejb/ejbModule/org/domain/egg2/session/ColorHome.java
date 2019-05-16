package org.domain.egg2.session;

import org.domain.egg2.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("colorHome")
public class ColorHome extends EntityHome<Color> {

	public void setColorId(Integer id) {
		setId(id);
	}

	public Integer getColorId() {
		return (Integer) getId();
	}

	@Override
	protected Color createInstance() {
		Color color = new Color();
		return color;
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

	public Color getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<BaseEgg> getBaseEggs() {
		return getInstance() == null ? null : new ArrayList<BaseEgg>(getInstance().getBaseEggs());
	}

	public List<Product> getProducts() {
		return getInstance() == null ? null : new ArrayList<Product>(getInstance().getProducts());
	}

}
