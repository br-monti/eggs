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
import org.hibernate.validator.NotNull;

/**
 * Production generated by hbm2java
 */
@Entity
@Table(name = "production", catalog = "db_egg")
public class Production implements java.io.Serializable {

	private int id;
	private BaseEgg baseEgg;
	private Date date;
	private Set<Productions> productions = new HashSet<Productions>(0);

	public Production() {
	}

	public Production(int id, BaseEgg baseEgg, Date date) {
		this.id = id;
		this.baseEgg = baseEgg;
		this.date = date;
	}

	public Production(int id, BaseEgg baseEgg, Date date, Set<Productions> productionses) {
		this.id = id;
		this.baseEgg = baseEgg;
		this.date = date;
		this.productions = productionses;
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
	@JoinColumn(name = "base_egg_id", nullable = false)
	@NotNull
	public BaseEgg getBaseEgg() {
		return this.baseEgg;
	}

	public void setBaseEgg(BaseEgg baseEgg) {
		this.baseEgg = baseEgg;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 10)
	@NotNull
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "production")
	public Set<Productions> getProductions() {
		return this.productions;
	}

	public void setProductions(Set<Productions> productions) {
		this.productions = productions;
	}

}
