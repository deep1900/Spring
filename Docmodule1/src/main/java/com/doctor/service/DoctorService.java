package com.doctor.service;

import java.util.List;

import com.doctor.entity.Doctor;

public interface DoctorService {

	public List<Doctor> getDoctor();

	public void saveDoctor(Doctor doctor);

	public Doctor getDoctor(int theId);

	public void deleteDoctor(int theId);
	
}
