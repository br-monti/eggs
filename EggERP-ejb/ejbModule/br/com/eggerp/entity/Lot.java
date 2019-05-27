package br.com.eggerp.entity;
// Generated 24/05/2019 13:05:07 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Lot generated by hbm2java
 */
@Entity
@Table(name = "lot", catalog = "db_egg")
public class Lot implements java.io.Serializable {

	private Integer id;
	private Lineage lineage;
	private Shed shed;
	private Date birth;
	private Date accommodation;
	private int initialQuantity;
	private int currentQuantity;
	private String debicking;
	private Set<CreationMonitoring> creationMonitorings = new HashSet<CreationMonitoring>(0);
	private Set<ProductionMonitoring> productionMonitorings = new HashSet<ProductionMonitoring>(0);

	public Lot() {
	}

	public Lot(Lineage lineage, Shed shed, Date birth, Date accommodation, int initialQuantity, int currentQuantity,
			String debicking) {
		this.lineage = lineage;
		this.shed = shed;
		this.birth = birth;
		this.accommodation = accommodation;
		this.initialQuantity = initialQuantity;
		this.currentQuantity = currentQuantity;
		this.debicking = debicking;
	}

	public Lot(Lineage lineage, Shed shed, Date birth, Date accommodation, int initialQuantity, int currentQuantity,
			String debicking, Set<CreationMonitoring> creationMonitorings,
			Set<ProductionMonitoring> productionMonitorings) {
		this.lineage = lineage;
		this.shed = shed;
		this.birth = birth;
		this.accommodation = accommodation;
		this.initialQuantity = initialQuantity;
		this.currentQuantity = currentQuantity;
		this.debicking = debicking;
		this.creationMonitorings = creationMonitorings;
		this.productionMonitorings = productionMonitorings;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lineage_id", nullable = false)
	@NotNull
	public Lineage getLineage() {
		return this.lineage;
	}

	public void setLineage(Lineage lineage) {
		this.lineage = lineage;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shed_id", nullable = false)
	@NotNull
	public Shed getShed() {
		return this.shed;
	}

	public void setShed(Shed shed) {
		this.shed = shed;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth", nullable = false, length = 10)
	@NotNull
	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "accommodation", nullable = false, length = 10)
	@NotNull
	public Date getAccommodation() {
		return this.accommodation;
	}

	public void setAccommodation(Date accommodation) {
		this.accommodation = accommodation;
	}

	@Column(name = "initial_quantity", nullable = false)
	public int getInitialQuantity() {
		return this.initialQuantity;
	}

	public void setInitialQuantity(int initialQuantity) {
		this.initialQuantity = initialQuantity;
	}

	@Column(name = "current_quantity", nullable = false)
	public int getCurrentQuantity() {
		return this.currentQuantity;
	}

	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	@Column(name = "debicking", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getDebicking() {
		return this.debicking;
	}

	public void setDebicking(String debicking) {
		this.debicking = debicking;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lot")
	public Set<CreationMonitoring> getCreationMonitorings() {
		return this.creationMonitorings;
	}

	public void setCreationMonitorings(Set<CreationMonitoring> creationMonitorings) {
		this.creationMonitorings = creationMonitorings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lot")
	public Set<ProductionMonitoring> getProductionMonitorings() {
		return this.productionMonitorings;
	}

	public void setProductionMonitorings(Set<ProductionMonitoring> productionMonitorings) {
		this.productionMonitorings = productionMonitorings;
	}

}