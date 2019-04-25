package br.com.egg.entity;
// Generated 25/04/2019 20:50:28 by Hibernate Tools 3.5.0.Final

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
 * Manufacturer generated by hbm2java
 */
@Entity
@Table(name = "manufacturer", catalog = "db_egg")
public class Manufacturer implements java.io.Serializable {

	private int id;
	private String manufacturer;
	private Set<Shed> sheds = new HashSet<Shed>(0);

	public Manufacturer() {
	}

	public Manufacturer(int id, String manufacturer) {
		this.id = id;
		this.manufacturer = manufacturer;
	}

	public Manufacturer(int id, String manufacturer, Set<Shed> sheds) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.sheds = sheds;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "manufacturer", nullable = false, length = 15)
	@NotNull
	@Length(max = 15)
	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer")
	public Set<Shed> getSheds() {
		return this.sheds;
	}

	public void setSheds(Set<Shed> sheds) {
		this.sheds = sheds;
	}

}
