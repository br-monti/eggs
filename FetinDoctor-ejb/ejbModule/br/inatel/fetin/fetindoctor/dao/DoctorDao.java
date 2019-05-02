package br.inatel.fetin.fetindoctor.dao;

import java.util.ArrayList;

import javax.ejb.Local;

import br.inatel.fetin.fetindoctor.entity.Doctor;


@Local
public interface DoctorDao extends GenericDAO<Doctor, Integer> {
	
	public ArrayList<Doctor> findDoctor(Doctor doctor);

	public void destroy();
	
	public void remove();


}
