package br.inatel.fetin.fetindoctor.entity;

// Generated 14/09/2015 20:44:26 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Patient generated by hbm2java
 */
@Entity
@Table(name = "patient", catalog = "telit_user_side")
public class Patient implements java.io.Serializable {

	private Integer id;
	private String name;
	private String address;
	private String sex;
	private String district;
	private String city;
	private String state;
	private String phone;
	private String cellphone;
	private String email;
	private Set<Prescription> prescriptions = new HashSet<Prescription>(0);

	public Patient() {
	}

	public Patient(String name, String address, String sex) {
		this.name = name;
		this.address = address;
		this.sex = sex;
	}

	public Patient(String name, String address, String sex, String district,
			String city, String state, String phone, String cellphone,
			String email, Set<Prescription> prescriptions) {
		this.name = name;
		this.address = address;
		this.sex = sex;
		this.district = district;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.cellphone = cellphone;
		this.email = email;
		this.prescriptions = prescriptions;
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

	@Column(name = "name", nullable = false, length = 100)
	@NotNull
	@Length(max = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address", nullable = false, length = 100)
	@NotNull
	@Length(max = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "sex", nullable = false, length = 1)
	@NotNull
	@Length(max = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "district", length = 45)
	@Length(max = 45)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "city", length = 45)
	@Length(max = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 45)
	@Length(max = 45)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "phone", length = 45)
	@Length(max = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "cellphone", length = 45)
	@Length(max = 45)
	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	@Column(name = "email", length = 45)
	@Length(max = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	public Set<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

}
