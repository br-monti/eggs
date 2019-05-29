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
 * Provider generated by hbm2java
 */
@Entity
@Table(name = "provider", catalog = "db_egg")
public class Provider implements java.io.Serializable {

	private int id;
	private String provider;
	private String cnpjCpf;
	private String sifIma;
	private String city;
	private String state;
	private String neighborhood;
	private String address;
	private Set<BaseEgg> baseEggs = new HashSet<BaseEgg>(0);

	public Provider() {
	}

	public Provider(int id, String provider, String cnpjCpf, String sifIma, String address, String city, String state,
			String neighborhood) {
		this.id = id;
		this.provider = provider;
		this.cnpjCpf = cnpjCpf;
		this.sifIma = sifIma;
		this.address = address;
		this.city = city;
		this.state = state;
		this.neighborhood = neighborhood;
	}

	public Provider(int id, String provider, String cnpjCpf, String sifIma, String address, String city, String state,
			String neighborhood, Set<BaseEgg> baseEggs) {
		this.id = id;
		this.provider = provider;
		this.cnpjCpf = cnpjCpf;
		this.sifIma = sifIma;
		this.address = address;
		this.city = city;
		this.state = state;
		this.neighborhood = neighborhood;
		this.baseEggs = baseEggs;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "provider", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Column(name = "CNPJ_CPF", nullable = false, length = 20)
	@NotNull
	@Length(max = 20)
	public String getCnpjCpf() {
		return this.cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	@Column(name = "SIF_IMA", nullable = false, length = 20)
	@NotNull
	@Length(max = 20)
	public String getSifIma() {
		return this.sifIma;
	}

	public void setSifIma(String sifIma) {
		this.sifIma = sifIma;
	}
	
	@Column(name = "address", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city", nullable = false, length = 20)
	@NotNull
	@Length(max = 20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", nullable = false, length = 2)
	@NotNull
	@Length(max = 2)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "neighborhood", nullable = false, length = 20)
	@NotNull
	@Length(max = 20)
	public String getNeighborhood() {
		return this.neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
	public Set<BaseEgg> getBaseEggs() {
		return this.baseEggs;
	}

	public void setBaseEggs(Set<BaseEgg> baseEggs) {
		this.baseEggs = baseEggs;
	}

}
