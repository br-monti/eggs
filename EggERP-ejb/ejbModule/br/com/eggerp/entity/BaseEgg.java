package br.com.eggerp.entity;
// Generated 26/05/2019 21:21:09 by Hibernate Tools 3.5.0.Final

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * BaseEgg generated by hbm2java
 */
@Entity
@Table(name = "base_egg", catalog = "db_egg")
public class BaseEgg implements java.io.Serializable {

	private int id;
	private Provider provider;
	private Color color;
	private Date productionDate;
	private Date validityDate;
	private int lot;
	private String quantity;
	private String balance;
	private Set<Production> productions = new HashSet<Production>(0);

	public BaseEgg() {
	}

	public BaseEgg(int id, Provider provider, Color color, Date productionDate, Date validityDate, int lot,
			String quantity, String balance) {
		this.id = id;
		this.provider = provider;
		this.color = color;
		this.productionDate = productionDate;
		this.validityDate = validityDate;
		this.lot = lot;
		this.quantity = quantity;
		this.balance = balance;
	}

	public BaseEgg(int id, Provider provider, Color color, Date productionDate, Date validityDate, int lot,
			String quantity, String balance, Set<Production> productions) {
		this.id = id;
		this.provider = provider;
		this.color = color;
		this.productionDate = productionDate;
		this.validityDate = validityDate;
		this.lot = lot;
		this.quantity = quantity;
		this.balance = balance;
		this.productions = productions;
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
	@JoinColumn(name = "provider_id", nullable = false)
	@NotNull
	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "productionDate", nullable = false, length = 10)
	@NotNull
	public Date getProductionDate() {
		return this.productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "validityDate", nullable = false, length = 10)
	@NotNull
	public Date getValidityDate() {
		return this.validityDate;
	}

	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	@Column(name = "lot", nullable = false)
	public int getLot() {
		return this.lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	@Column(name = "quantity", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Column(name = "balance", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getBalance() {
		return this.balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "baseEgg")
	public Set<Production> getProductions() {
		return this.productions;
	}

	public void setProductions(Set<Production> productions) {
		this.productions = productions;
	}

}
