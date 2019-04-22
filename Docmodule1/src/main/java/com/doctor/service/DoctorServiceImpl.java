package com.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doctor.dao.DoctorDao;
import com.doctor.dao.DoctorDaoImpl;
import com.doctor.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	// need to inject customer dao
	@Autowired
	private DoctorDao daoImplementation;
//	
//	@Override
//	@Transactional
//	public List<Doctor>getPatient() {
//		return daoImplementation.getPatient();
//	}
//
//	@Override
//	@Transactional
//	public void savePatient(Doctor patient) {
//
//		daoImplementation.savePatient(patient);
//	}
//
//	@Override
//	@Transactional
//	public Doctor getPatient(int id) {
//		
//		return daoImplementation.getPatientById(id);
//	}
//
//	@Override
//	@Transactional
//	public void deletePatient(int id) {
//		
//		daoImplementation.deletePatient(id);
//	}
	@Transactional
	public List<Doctor> getDoctor() {
		return daoImplementation.getDoctor();
	}
	
	@Transactional
	public void saveDoctor(Doctor doctor) {
		daoImplementation.saveDoctor(doctor);		
	}
	
	@Transactional
	public Doctor getDoctor(int id) {
		return daoImplementation.getDoctorbyId(id);
	}
	@Transactional
	public void deleteDoctor(int id) {
		daoImplementation.deleteDoctor(id);		
	}
	

}





