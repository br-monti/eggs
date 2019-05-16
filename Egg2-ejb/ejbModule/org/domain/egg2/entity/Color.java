package org.domain.egg2.entity;
// Generated 16/05/2019 18:26:57 by Hibernate Tools 3.5.0.Final

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
 * Color generated by hbm2java
 */
@Entity
@Table(name = "color", catalog = "db_egg_2")
public class Color implements java.io.Serializable {

	private int id;
	private String color;
	private Set<BaseEgg> baseEggs = new HashSet<BaseEgg>(0);
	private Set<Product> products = new HashSet<Product>(0);

	public Color() {
	}

	public Color(int id, String color) {
		this.id = id;
		this.color = color;
	}

	public Color(int id, String color, Set<BaseEgg> baseEggs, Set<Product> products) {
		this.id = id;
		this.color = color;
		this.baseEggs = baseEggs;
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

	@Column(name = "color", nullable = false, length = 10)
	@NotNull
	@Length(max = 10)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "color")
	public Set<BaseEgg> getBaseEggs() {
		return this.baseEggs;
	}

	public void setBaseEggs(Set<BaseEgg> baseEggs) {
		this.baseEggs = baseEggs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "color")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
