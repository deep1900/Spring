package com.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patient.dao.PatientDao;
import com.patient.dao.PatientDaoImpl;
import com.patient.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	// need to inject customer dao
	@Autowired
	private PatientDao daoImplementation;
	
	@Override
	@Transactional
	public List<Patient>getPatient() {
		return daoImplementation.getPatient();
	}

	@Override
	@Transactional
	public void savePatient(Patient patient) {

		daoImplementation.savePatient(patient);
	}

	@Override
	@Transactional
	public Patient getPatient(int id) {
		
		return daoImplementation.getPatientById(id);
	}

	@Override
	@Transactional
	public void deletePatient(int id) {
		
		daoImplementation.deletePatient(id);
	}

}





