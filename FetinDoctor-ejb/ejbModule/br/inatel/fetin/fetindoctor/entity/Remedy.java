package br.inatel.fetin.fetindoctor.entity;

// Generated 14/09/2015 20:44:26 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Remedy generated by hbm2java
 */
@Entity
@Table(name = "remedy", catalog = "telit_user_side")
public class Remedy implements java.io.Serializable {

	private Integer id;
	private String name;
	private String form;
	private String concentration;
	private String laboratory;
	private Set<PrescriptionRemedy> prescriptionRemedies = new HashSet<PrescriptionRemedy>(
			0);

	public Remedy() {
	}

	public Remedy(String name, String form, String concentration) {
		this.name = name;
		this.form = form;
		this.concentration = concentration;
	}

	public Remedy(String name, String form, String concentration,
			String laboratory, Set<PrescriptionRemedy> prescriptionRemedies) {
		this.name = name;
		this.form = form;
		this.concentration = concentration;
		this.laboratory = laboratory;
		this.prescriptionRemedies = prescriptionRemedies;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "form", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getForm() {
		return this.form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	@Column(name = "concentration", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getConcentration() {
		return this.concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}

	@Column(name = "laboratory", length = 45)
	@Length(max = 45)
	public String getLaboratory() {
		return this.laboratory;
	}

	public void setLaboratory(String laboratory) {
		this.laboratory = laboratory;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "remedy")
	public Set<PrescriptionRemedy> getPrescriptionRemedies() {
		return this.prescriptionRemedies;
	}

	public void setPrescriptionRemedies(
			Set<PrescriptionRemedy> prescriptionRemedies) {
		this.prescriptionRemedies = prescriptionRemedies;
	}

}
