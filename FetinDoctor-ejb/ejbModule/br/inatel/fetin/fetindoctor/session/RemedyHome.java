package br.inatel.fetin.fetindoctor.session;

import br.inatel.fetin.fetindoctor.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("remedyHome")
public class RemedyHome extends EntityHome<Remedy> {

	public void setRemedyId(Integer id) {
		setId(id);
	}

	public Integer getRemedyId() {
		return (Integer) getId();
	}

	@Override
	protected Remedy createInstance() {
		Remedy remedy = new Remedy();
		return remedy;
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

	public Remedy getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<PrescriptionRemedy> getPrescriptionRemedies() {
		return getInstance() == null ? null
				: new ArrayList<PrescriptionRemedy>(getInstance()
						.getPrescriptionRemedies());
	}

}
