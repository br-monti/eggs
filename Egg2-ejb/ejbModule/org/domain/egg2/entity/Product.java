package org.domain.egg2.entity;
// Generated 16/05/2019 18:26:57 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "db_egg_2")
public class Product implements java.io.Serializable {

	private int id;
	private Packing packing;
	private Color color;
	private Type type;
	private String product;
	private String barcode;
	private Set<ProductionProduct> productionProducts = new HashSet<ProductionProduct>(0);

	public Product() {
	}

	public Product(int id, Packing packing, Color color, Type type, String product, String barcode) {
		this.id = id;
		this.packing = packing;
		this.color = color;
		this.type = type;
		this.product = product;
		this.barcode = barcode;
	}

	public Product(int id, Packing packing, Color color, Type type, String product, String barcode,
			Set<ProductionProduct> productionProducts) {
		this.id = id;
		this.packing = packing;
		this.color = color;
		this.type = type;
		this.product = product;
		this.barcode = barcode;
		this.productionProducts = productionProducts;
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
	@JoinColumn(name = "packing_id", nullable = false)
	@NotNull
	public Packing getPacking() {
		return this.packing;
	}

	public void setPacking(Packing packing) {
		this.packing = packing;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "color_id", nullable = false)
	@NotNull
	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id", nullable = false)
	@NotNull
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Column(name = "product", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Column(name = "barcode", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<ProductionProduct> getProductionProducts() {
		return this.productionProducts;
	}

	public void setProductionProducts(Set<ProductionProduct> productionProducts) {
		this.productionProducts = productionProducts;
	}

}
