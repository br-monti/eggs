package br.com.eggerp.entity;
// Generated 24/05/2019 13:05:07 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.NotNull;

/**
 * ProductionMonitoring generated by hbm2java
 */
@Entity
@Table(name = "production_monitoring", catalog = "db_egg")
public class ProductionMonitoring implements java.io.Serializable {

	private Integer id;
	private Lot lot;
	private int ageWeek;
	private int ageDay;
	private Date dateWeek;
	private int discard;
	private int mortality;
	private int totalProduction;
	private int firstEggs;
	private int secondEggs;
	private int bodyWeight;
	private int eggWeight;
	private int food;
	private int water;

	public ProductionMonitoring() {
	}

	public ProductionMonitoring(Lot lot, int ageWeek, int ageDay, Date dateWeek, int discard, int mortality,
			int totalProduction, int firstEggs, int secondEggs, int bodyWeight, int eggWeight, int food, int water) {
		this.lot = lot;
		this.ageWeek = ageWeek;
		this.ageDay = ageDay;
		this.dateWeek = dateWeek;
		this.discard = discard;
		this.mortality = mortality;
		this.totalProduction = totalProduction;
		this.firstEggs = firstEggs;
		this.secondEggs = secondEggs;
		this.bodyWeight = bodyWeight;
		this.eggWeight = eggWeight;
		this.food = food;
		this.water = water;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lot_id", nullable = false)
	@NotNull
	public Lot getLot() {
		return this.lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	@Column(name = "ageWeek", nullable = false)
	public int getAgeWeek() {
		return this.ageWeek;
	}

	public void setAgeWeek(int ageWeek) {
		this.ageWeek = ageWeek;
	}

	@Column(name = "ageDay", nullable = false)
	public int getAgeDay() {
		return this.ageDay;
	}

	public void setAgeDay(int ageDay) {
		this.ageDay = ageDay;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateWeek", nullable = false, length = 10)
	@NotNull
	public Date getDateWeek() {
		return this.dateWeek;
	}

	public void setDateWeek(Date dateWeek) {
		this.dateWeek = dateWeek;
	}

	@Column(name = "discard", nullable = false)
	public int getDiscard() {
		return this.discard;
	}

	public void setDiscard(int discard) {
		this.discard = discard;
	}

	@Column(name = "mortality", nullable = false)
	public int getMortality() {
		return this.mortality;
	}

	public void setMortality(int mortality) {
		this.mortality = mortality;
	}

	@Column(name = "totalProduction", nullable = false)
	public int getTotalProduction() {
		return this.totalProduction;
	}

	public void setTotalProduction(int totalProduction) {
		this.totalProduction = totalProduction;
	}

	@Column(name = "firstEggs", nullable = false)
	public int getFirstEggs() {
		return this.firstEggs;
	}

	public void setFirstEggs(int firstEggs) {
		this.firstEggs = firstEggs;
	}

	@Column(name = "secondEggs", nullable = false)
	public int getSecondEggs() {
		return this.secondEggs;
	}

	public void setSecondEggs(int secondEggs) {
		this.secondEggs = secondEggs;
	}

	@Column(name = "bodyWeight", nullable = false)
	public int getBodyWeight() {
		return this.bodyWeight;
	}

	public void setBodyWeight(int bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	@Column(name = "eggWeight", nullable = false)
	public int getEggWeight() {
		return this.eggWeight;
	}

	public void setEggWeight(int eggWeight) {
		this.eggWeight = eggWeight;
	}

	@Column(name = "food", nullable = false)
	public int getFood() {
		return this.food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	@Column(name = "water", nullable = false)
	public int getWater() {
		return this.water;
	}

	public void setWater(int water) {
		this.water = water;
	}

}