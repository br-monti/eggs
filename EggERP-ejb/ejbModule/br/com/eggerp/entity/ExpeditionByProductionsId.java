package br.com.eggerp.entity;
// Generated 26/05/2019 21:21:09 by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ExpeditionByProductionsId generated by hbm2java
 */
@Embeddable
public class ExpeditionByProductionsId implements java.io.Serializable {

	private int id;
	private int expeditionId;
	private int productionsId;
	private int productionsProductId;
	private int productionsProductionId;

	public ExpeditionByProductionsId() {
	}

	public ExpeditionByProductionsId(int id, int expeditionId, int productionsId, int productionsProductId,
			int productionsProductionId) {
		this.id = id;
		this.expeditionId = expeditionId;
		this.productionsId = productionsId;
		this.productionsProductId = productionsProductId;
		this.productionsProductionId = productionsProductionId;
	}

	@Column(name = "id", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "expedition_id", nullable = false)
	public int getExpeditionId() {
		return this.expeditionId;
	}

	public void setExpeditionId(int expeditionId) {
		this.expeditionId = expeditionId;
	}

	@Column(name = "productions_id", nullable = false)
	public int getProductionsId() {
		return this.productionsId;
	}

	public void setProductionsId(int productionsId) {
		this.productionsId = productionsId;
	}

	@Column(name = "productions_product_id", nullable = false)
	public int getProductionsProductId() {
		return this.productionsProductId;
	}

	public void setProductionsProductId(int productionsProductId) {
		this.productionsProductId = productionsProductId;
	}

	@Column(name = "productions_production_id", nullable = false)
	public int getProductionsProductionId() {
		return this.productionsProductionId;
	}

	public void setProductionsProductionId(int productionsProductionId) {
		this.productionsProductionId = productionsProductionId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ExpeditionByProductionsId))
			return false;
		ExpeditionByProductionsId castOther = (ExpeditionByProductionsId) other;

		return (this.getId() == castOther.getId()) && (this.getExpeditionId() == castOther.getExpeditionId())
				&& (this.getProductionsId() == castOther.getProductionsId())
				&& (this.getProductionsProductId() == castOther.getProductionsProductId())
				&& (this.getProductionsProductionId() == castOther.getProductionsProductionId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getExpeditionId();
		result = 37 * result + this.getProductionsId();
		result = 37 * result + this.getProductionsProductId();
		result = 37 * result + this.getProductionsProductionId();
		return result;
	}

}