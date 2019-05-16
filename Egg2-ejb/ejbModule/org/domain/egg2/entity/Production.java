package org.domain.egg2.entity;
// Generated 16/05/2019 18:26:57 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.NotNull;

/**
 * Production generated by hbm2java
 */
@Entity
@Table(name = "production", catalog = "db_egg_2")
public class Production implements java.io.Serializable {

	private int id;
	private BaseEgg baseEgg;
	private Date date;
	private Set<ProductionProduct> productionProducts = new HashSet<ProductionProduct>(0);
	private Set<Expedition> expeditions = new HashSet<Expedition>(0);

	public Production() {
	}

	public Production(int id, BaseEgg baseEgg) {
		this.id = id;
		this.baseEgg = baseEgg;
	}

	public Production(int id, BaseEgg baseEgg, Date date, Set<ProductionProduct> productionProducts,
			Set<Expedition> expeditions) {
		this.id = id;
		this.baseEgg = baseEgg;
		this.date = date;
		this.productionProducts = productionProducts;
		this.expeditions = expeditions;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "base_egg_id", nullable = false)
	@NotNull
	public BaseEgg getBaseEgg() {
		return this.baseEgg;
	}

	public void setBaseEgg(BaseEgg baseEgg) {
		this.baseEgg = baseEgg;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "production")
	public Set<ProductionProduct> getProductionProducts() {
		return this.productionProducts;
	}

	public void setProductionProducts(Set<ProductionProduct> productionProducts) {
		this.productionProducts = productionProducts;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "expedition_has_production", catalog = "db_egg_2", joinColumns = {
			@JoinColumn(name = "production_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "expedition_id", nullable = false, updatable = false) })
	public Set<Expedition> getExpeditions() {
		return this.expeditions;
	}

	public void setExpeditions(Set<Expedition> expeditions) {
		this.expeditions = expeditions;
	}

}
