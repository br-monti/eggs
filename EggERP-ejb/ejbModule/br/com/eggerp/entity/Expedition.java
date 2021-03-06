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
 * Expedition generated by hbm2java
 */
@Entity
@Table(name = "expedition", catalog = "db_egg")
public class Expedition implements java.io.Serializable {

	private int id;
	private Line line;
	private Date date;
	private Set<ExpeditionByProductions> expeditionByProductionses = new HashSet<ExpeditionByProductions>(0);

	public Expedition() {
	}

	public Expedition(int id, Line line, Date date) {
		this.id = id;
		this.line = line;
		this.date = date;
	}

	public Expedition(int id, Line line, Date date, Set<ExpeditionByProductions> expeditionByProductionses) {
		this.id = id;
		this.line = line;
		this.date = date;
		this.expeditionByProductionses = expeditionByProductionses;
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
	@JoinColumn(name = "line_id", nullable = false)
	@NotNull
	public Line getLine() {
		return this.line;
	}

	public void setLine(Line line) {
		this.line = line;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expedition")
	public Set<ExpeditionByProductions> getExpeditionByProductionses() {
		return this.expeditionByProductionses;
	}

	public void setExpeditionByProductionses(Set<ExpeditionByProductions> expeditionByProductionses) {
		this.expeditionByProductionses = expeditionByProductionses;
	}

}
