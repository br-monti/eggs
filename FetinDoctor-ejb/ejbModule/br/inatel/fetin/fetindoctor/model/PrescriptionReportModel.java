package br.inatel.fetin.fetindoctor.model;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;


@Name("prescriptionReportModel") 
@Scope(ScopeType.CONVERSATION)
public class PrescriptionReportModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String field_doctor_name;
	public String field_doctor_speciality;
	public String field_doctor_crm;
	public String field_doctor_cpf;
	
	public String field_clinic_name;
	public String field_clinic_address;
	public String field_clinic_cnpj;
	
	public String field_patient_name;	
	public String field_patient_sex;
	public String field_patient_address;
	
	public String field_remedy1_name;	
	public String field_remedy1_form;
	public String field_remedy1_concentration;	
	public String field_remedy1_total;
	public String field_remedy1_observation;
	
	public String field_remedy2_name;	
	public String field_remedy2_form;
	public String field_remedy2_concentration;	
	public String field_remedy2_total;
	public String field_remedy2_observation;
	
	public String field_remedy3_name;	
	public String field_remedy3_form;
	public String field_remedy3_concentration;	
	public String field_remedy3_total;
	public String field_remedy3_observation;
	
	public String field_remedy4_name;	
	public String field_remedy4_form;
	public String field_remedy4_concentration;	
	public String field_remedy4_total;
	public String field_remedy4_observation;
	
	public String field_remedy5_name;	
	public String field_remedy5_form;
	public String field_remedy5_concentration;	
	public String field_remedy5_total;
	public String field_remedy5_observation;	
	
	public String field_date;
	
	public String field_acess_code;
	
	public String prescriptionType;

	public String getField_doctor_name() {
		return field_doctor_name;
	}

	public void setField_doctor_name(String field_doctor_name) {
		this.field_doctor_name = field_doctor_name;
	}

	public String getField_doctor_speciality() {
		return field_doctor_speciality;
	}

	public void setField_doctor_speciality(String field_doctor_speciality) {
		this.field_doctor_speciality = field_doctor_speciality;
	}

	public String getField_doctor_crm() {
		return field_doctor_crm;
	}

	public void setField_doctor_crm(String field_doctor_crm) {
		this.field_doctor_crm = field_doctor_crm;
	}

	public String getField_doctor_cpf() {
		return field_doctor_cpf;
	}

	public void setField_doctor_cpf(String field_doctor_cpf) {
		this.field_doctor_cpf = field_doctor_cpf;
	}

	public String getField_clinic_name() {
		return field_clinic_name;
	}

	public void setField_clinic_name(String field_clinic_name) {
		this.field_clinic_name = field_clinic_name;
	}

	public String getField_clinic_address() {
		return field_clinic_address;
	}

	public void setField_clinic_address(String field_clinic_address) {
		this.field_clinic_address = field_clinic_address;
	}

	public String getField_clinic_cnpj() {
		return field_clinic_cnpj;
	}

	public void setField_clinic_cnpj(String field_clinic_cnpj) {
		this.field_clinic_cnpj = field_clinic_cnpj;
	}

	public String getField_patient_name() {
		return field_patient_name;
	}

	public void setField_patient_name(String field_patient_name) {
		this.field_patient_name = field_patient_name;
	}

	public String getField_patient_sex() {
		return field_patient_sex;
	}

	public void setField_patient_sex(String field_patient_sex) {
		this.field_patient_sex = field_patient_sex;
	}

	public String getField_patient_address() {
		return field_patient_address;
	}

	public void setField_patient_address(String field_patient_address) {
		this.field_patient_address = field_patient_address;
	}

	public String getField_remedy1_name() {
		return field_remedy1_name;
	}

	public void setField_remedy1_name(String field_remedy1_name) {
		this.field_remedy1_name = field_remedy1_name;
	}

	public String getField_remedy1_form() {
		return field_remedy1_form;
	}

	public void setField_remedy1_form(String field_remedy1_form) {
		this.field_remedy1_form = field_remedy1_form;
	}

	public String getField_remedy1_concentration() {
		return field_remedy1_concentration;
	}

	public void setField_remedy1_concentration(String field_remedy1_concentration) {
		this.field_remedy1_concentration = field_remedy1_concentration;
	}

	public String getField_remedy1_total() {
		return field_remedy1_total;
	}

	public void setField_remedy1_total(String field_remedy1_total) {
		this.field_remedy1_total = field_remedy1_total;
	}

	public String getField_acess_code() {
		return field_acess_code;
	}

	public void setField_acess_code(String field_acess_code) {
		this.field_acess_code = field_acess_code;
	}

	public String getField_remedy1_observation() {
		return field_remedy1_observation;
	}

	public void setField_remedy1_observation(String field_remedy1_observation) {
		this.field_remedy1_observation = field_remedy1_observation;
	}

	public String getField_remedy2_name() {
		return field_remedy2_name;
	}

	public void setField_remedy2_name(String field_remedy2_name) {
		this.field_remedy2_name = field_remedy2_name;
	}

	public String getField_remedy2_form() {
		return field_remedy2_form;
	}

	public void setField_remedy2_form(String field_remedy2_form) {
		this.field_remedy2_form = field_remedy2_form;
	}

	public String getField_remedy2_concentration() {
		return field_remedy2_concentration;
	}

	public void setField_remedy2_concentration(String field_remedy2_concentration) {
		this.field_remedy2_concentration = field_remedy2_concentration;
	}

	public String getField_remedy2_total() {
		return field_remedy2_total;
	}

	public void setField_remedy2_total(String field_remedy2_total) {
		this.field_remedy2_total = field_remedy2_total;
	}

	public String getField_remedy2_observation() {
		return field_remedy2_observation;
	}

	public void setField_remedy2_observation(String field_remedy2_observation) {
		this.field_remedy2_observation = field_remedy2_observation;
	}

	public String getField_remedy3_name() {
		return field_remedy3_name;
	}

	public void setField_remedy3_name(String field_remedy3_name) {
		this.field_remedy3_name = field_remedy3_name;
	}

	public String getField_remedy3_form() {
		return field_remedy3_form;
	}

	public void setField_remedy3_form(String field_remedy3_form) {
		this.field_remedy3_form = field_remedy3_form;
	}

	public String getField_remedy3_concentration() {
		return field_remedy3_concentration;
	}

	public void setField_remedy3_concentration(String field_remedy3_concentration) {
		this.field_remedy3_concentration = field_remedy3_concentration;
	}

	public String getField_remedy3_total() {
		return field_remedy3_total;
	}

	public void setField_remedy3_total(String field_remedy3_total) {
		this.field_remedy3_total = field_remedy3_total;
	}

	public String getField_remedy3_observation() {
		return field_remedy3_observation;
	}

	public void setField_remedy3_observation(String field_remedy3_observation) {
		this.field_remedy3_observation = field_remedy3_observation;
	}

	public String getField_remedy4_name() {
		return field_remedy4_name;
	}

	public void setField_remedy4_name(String field_remedy4_name) {
		this.field_remedy4_name = field_remedy4_name;
	}

	public String getField_remedy4_form() {
		return field_remedy4_form;
	}

	public void setField_remedy4_form(String field_remedy4_form) {
		this.field_remedy4_form = field_remedy4_form;
	}

	public String getField_remedy4_concentration() {
		return field_remedy4_concentration;
	}

	public void setField_remedy4_concentration(String field_remedy4_concentration) {
		this.field_remedy4_concentration = field_remedy4_concentration;
	}

	public String getField_remedy4_total() {
		return field_remedy4_total;
	}

	public void setField_remedy4_total(String field_remedy4_total) {
		this.field_remedy4_total = field_remedy4_total;
	}

	public String getField_remedy4_observation() {
		return field_remedy4_observation;
	}

	public void setField_remedy4_observation(String field_remedy4_observation) {
		this.field_remedy4_observation = field_remedy4_observation;
	}

	public String getField_remedy5_name() {
		return field_remedy5_name;
	}

	public void setField_remedy5_name(String field_remedy5_name) {
		this.field_remedy5_name = field_remedy5_name;
	}

	public String getField_remedy5_form() {
		return field_remedy5_form;
	}

	public void setField_remedy5_form(String field_remedy5_form) {
		this.field_remedy5_form = field_remedy5_form;
	}

	public String getField_remedy5_concentration() {
		return field_remedy5_concentration;
	}

	public void setField_remedy5_concentration(String field_remedy5_concentration) {
		this.field_remedy5_concentration = field_remedy5_concentration;
	}

	public String getField_remedy5_total() {
		return field_remedy5_total;
	}

	public void setField_remedy5_total(String field_remedy5_total) {
		this.field_remedy5_total = field_remedy5_total;
	}

	public String getField_remedy5_observation() {
		return field_remedy5_observation;
	}

	public void setField_remedy5_observation(String field_remedy5_observation) {
		this.field_remedy5_observation = field_remedy5_observation;
	}

	public String getField_date() {
		return field_date;
	}

	public void setField_date(String field_date) {
		this.field_date = field_date;
	}

	public String getPrescriptionType() {
		return prescriptionType;
	}

	public void setPrescriptionType(String prescriptionType) {
		this.prescriptionType = prescriptionType;
	}
	
	
	
	
	

}
