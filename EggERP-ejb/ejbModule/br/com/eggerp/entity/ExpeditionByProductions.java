package br.com.eggerp.entity;
// Generated 26/05/2019 21:21:09 by Hibernate Tools 3.5.0.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * ExpeditionByProductions generated by hbm2java
 */
@Entity
@Table(name = "expedition_by_productions", catalog = "db_egg")
public class ExpeditionByProductions implements java.io.Serializable {

	private ExpeditionByProductionsId id;
	private Productions productions;
	private Expedition expedition;
	private int expeditionQuantity;
	private int expeditionReturn;
	private int expeditionChanges;

	public ExpeditionByProductions() {
	}

	public ExpeditionByProductions(ExpeditionByProductionsId id, Productions productions, Expedition expedition,
			int expeditionQuantity, int expeditionReturn, int expeditionChanges) {
		this.id = id;
		this.productions = productions;
		this.expedition = expedition;
		this.expeditionQuantity = expeditionQuantity;
		this.expeditionReturn = expeditionReturn;
		this.expeditionChanges = expeditionChanges;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "expeditionId", column = @Column(name = "expedition_id", nullable = false)),
			@AttributeOverride(name = "productionsId", column = @Column(name = "productions_id", nullable = false)),
			@AttributeOverride(name = "productionsProductId", column = @Column(name = "productions_product_id", nullable = false)),
			@AttributeOverride(name = "productionsProductionId", column = @Column(name = "productions_production_id", nullable = false)) })
	@NotNull
	public ExpeditionByProductionsId getId() {
		return this.id;
	}

	public void setId(ExpeditionByProductionsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "productions_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "productions_product_id", referencedColumnName = "product_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "productions_production_id", referencedColumnName = "production_id", nullable = false, insertable = false, updatable = false) })
	@NotNull
	public Productions getProductions() {
		return this.productions;
	}

	public void setProductions(Productions productions) {
		this.productions = productions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expedition_id", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Expedition getExpedition() {
		return this.expedition;
	}

	public void setExpedition(Expedition expedition) {
		this.expedition = expedition;
	}

	@Column(name = "expedition_quantity", nullable = false)
	public int getExpeditionQuantity() {
		return this.expeditionQuantity;
	}

	public void setExpeditionQuantity(int expeditionQuantity) {
		this.expeditionQuantity = expeditionQuantity;
	}

	@Column(name = "expedition_return", nullable = false)
	public int getExpeditionReturn() {
		return this.expeditionReturn;
	}

	public void setExpeditionReturn(int expeditionReturn) {
		this.expeditionReturn = expeditionReturn;
	}

	@Column(name = "expedition_changes", nullable = false)
	public int getExpeditionChanges() {
		return this.expeditionChanges;
	}

	public void setExpeditionChanges(int expeditionChanges) {
		this.expeditionChanges = expeditionChanges;
	}

}
