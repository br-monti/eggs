package br.inatel.fetin.fetindoctor.entity;

// Generated 14/09/2015 20:44:26 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PrescriptionRemedyId generated by hbm2java
 */
@Embeddable
public class PrescriptionRemedyId implements java.io.Serializable {

	private int id;
	private int prescriptionId;
	private int remedyId;

	public PrescriptionRemedyId() {
	}

	public PrescriptionRemedyId(int id, int prescriptionId, int remedyId) {
		this.id = id;
		this.prescriptionId = prescriptionId;
		this.remedyId = remedyId;
	}

	@Column(name = "id", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "prescription_id", nullable = false)
	public int getPrescriptionId() {
		return this.prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	@Column(name = "remedy_id", nullable = false)
	public int getRemedyId() {
		return this.remedyId;
	}

	public void setRemedyId(int remedyId) {
		this.remedyId = remedyId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PrescriptionRemedyId))
			return false;
		PrescriptionRemedyId castOther = (PrescriptionRemedyId) other;

		return (this.getId() == castOther.getId())
				&& (this.getPrescriptionId() == castOther.getPrescriptionId())
				&& (this.getRemedyId() == castOther.getRemedyId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getPrescriptionId();
		result = 37 * result + this.getRemedyId();
		return result;
	}

}
