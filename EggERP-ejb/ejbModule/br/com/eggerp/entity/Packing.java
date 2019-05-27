package br.com.eggerp.entity;
// Generated 26/05/2019 21:21:09 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Packing generated by hbm2java
 */
@Entity
@Table(name = "packing", catalog = "db_egg")
public class Packing implements java.io.Serializable {

	private int id;
	private String packing;
	private String type;
	private int eggQuantity;
	private Set<Product> products = new HashSet<Product>(0);

	public Packing() {
	}

	public Packing(int id, String packing, String type, int eggQuantity) {
		this.id = id;
		this.packing = packing;
		this.type = type;
		this.eggQuantity = eggQuantity;
	}

	public Packing(int id, String packing, String type, int eggQuantity, Set<Product> products) {
		this.id = id;
		this.packing = packing;
		this.type = type;
		this.eggQuantity = eggQuantity;
		this.products = products;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "packing", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getPacking() {
		return this.packing;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}

	@Column(name = "type", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "egg_quantity", nullable = false)
	public int getEggQuantity() {
		return this.eggQuantity;
	}

	public void setEggQuantity(int eggQuantity) {
		this.eggQuantity = eggQuantity;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "packing")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}