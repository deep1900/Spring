package com.patient.dao;

import java.util.List;

import com.patient.entity.Patient;

public interface PatientDao
{
	public List<Patient> getPatient();
	public Patient getPatientById(int id);
	public void savePatient(Patient patient);
	public void deletePatient(int id);
	
	
	

}
