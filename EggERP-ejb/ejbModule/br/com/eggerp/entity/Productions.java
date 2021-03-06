package br.com.eggerp.entity;
// Generated 26/05/2019 21:21:09 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * Productions generated by hbm2java
 */
@Entity
@Table(name = "productions", catalog = "db_egg")
public class Productions implements java.io.Serializable {

	private ProductionsId id;
	private Product product;
	private Production production;
	private int balance;
	private int productionQuantity;
	private Set<ExpeditionByProductions> expeditionByProductionses = new HashSet<ExpeditionByProductions>(0);

	public Productions() {
	}

	public Productions(ProductionsId id, Product product, Production production, int balance, int productionQuantity) {
		this.id = id;
		this.product = product;
		this.production = production;
		this.balance = balance;
		this.productionQuantity = productionQuantity;
	}

	public Productions(ProductionsId id, Product product, Production production, int balance, int productionQuantity,
			Set<ExpeditionByProductions> expeditionByProductionses) {
		this.id = id;
		this.product = product;
		this.production = production;
		this.balance = balance;
		this.productionQuantity = productionQuantity;
		this.expeditionByProductionses = expeditionByProductionses;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
			@AttributeOverride(name = "productionId", column = @Column(name = "production_id", nullable = false)) })
	@NotNull
	public ProductionsId getId() {
		return this.id;
	}

	public void setId(ProductionsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "production_id", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Production getProduction() {
		return this.production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	@Column(name = "balance", nullable = false)
	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Column(name = "production_quantity", nullable = false)
	public int getProductionQuantity() {
		return this.productionQuantity;
	}

	public void setProductionQuantity(int productionQuantity) {
		this.productionQuantity = productionQuantity;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productions")
	public Set<ExpeditionByProductions> getExpeditionByProductionses() {
		return this.expeditionByProductionses;
	}

	public void setExpeditionByProductionses(Set<ExpeditionByProductions> expeditionByProductionses) {
		this.expeditionByProductionses = expeditionByProductionses;
	}

}
