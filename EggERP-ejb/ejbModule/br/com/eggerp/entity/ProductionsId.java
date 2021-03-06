package br.com.eggerp.entity;
// Generated 26/05/2019 21:21:09 by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductionsId generated by hbm2java
 */
@Embeddable
public class ProductionsId implements java.io.Serializable {

	private int id;
	private int productId;
	private int productionId;

	public ProductionsId() {
	}

	public ProductionsId(int id, int productId, int productionId) {
		this.id = id;
		this.productId = productId;
		this.productionId = productionId;
	}

	@Column(name = "id", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "product_id", nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "production_id", nullable = false)
	public int getProductionId() {
		return this.productionId;
	}

	public void setProductionId(int productionId) {
		this.productionId = productionId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductionsId))
			return false;
		ProductionsId castOther = (ProductionsId) other;

		return (this.getId() == castOther.getId()) && (this.getProductId() == castOther.getProductId())
				&& (this.getProductionId() == castOther.getProductionId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getProductId();
		result = 37 * result + this.getProductionId();
		return result;
	}

}
