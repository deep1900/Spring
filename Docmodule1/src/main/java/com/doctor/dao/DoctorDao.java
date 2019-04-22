package com.doctor.dao;

import java.util.List;

import com.doctor.entity.Doctor;

public interface DoctorDao
{
	public List<Doctor> getDoctor();
	public Doctor getDoctorbyId(int id);
	public void saveDoctor(Doctor patient);
	public void deleteDoctor(int id);
	
	
	

}
