package com.patient.service;

import java.util.List;

import com.patient.entity.Patient;

public interface PatientService {

	public List<Patient> getPatient();

	public void savePatient(Patient theCustomer);

	public Patient getPatient(int theId);

	public void deletePatient(int theId);
	
}
