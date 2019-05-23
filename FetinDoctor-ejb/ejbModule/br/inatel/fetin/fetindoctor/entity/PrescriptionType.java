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
 * PrescriptionType generated by hbm2java
 */
@Entity
@Table(name = "prescription_type", catalog = "telit_user_side")
public class PrescriptionType implements java.io.Serializable {

	private Integer id;
	private String notificationType;
	private String lists;
	private String remedyType;
	private String color;
	private int maximumAmount;
	private String validity;
	private Set<Prescription> prescriptions = new HashSet<Prescription>(0);

	public PrescriptionType() {
	}

	public PrescriptionType(String notificationType, String lists,
			String remedyType, String color, int maximumAmount, String validity) {
		this.notificationType = notificationType;
		this.lists = lists;
		this.remedyType = remedyType;
		this.color = color;
		this.maximumAmount = maximumAmount;
		this.validity = validity;
	}

	public PrescriptionType(String notificationType, String lists,
			String remedyType, String color, int maximumAmount,
			String validity, Set<Prescription> prescriptions) {
		this.notificationType = notificationType;
		this.lists = lists;
		this.remedyType = remedyType;
		this.color = color;
		this.maximumAmount = maximumAmount;
		this.validity = validity;
		this.prescriptions = prescriptions;
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

	@Column(name = "notification_type", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getNotificationType() {
		return this.notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	@Column(name = "lists", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getLists() {
		return this.lists;
	}

	public void setLists(String lists) {
		this.lists = lists;
	}

	@Column(name = "remedy_type", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getRemedyType() {
		return this.remedyType;
	}

	public void setRemedyType(String remedyType) {
		this.remedyType = remedyType;
	}

	@Column(name = "color", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "maximum_amount", nullable = false)
	public int getMaximumAmount() {
		return this.maximumAmount;
	}

	public void setMaximumAmount(int maximumAmount) {
		this.maximumAmount = maximumAmount;
	}

	@Column(name = "validity", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getValidity() {
		return this.validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prescriptionType")
	public Set<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

}