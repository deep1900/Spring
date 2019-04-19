package com.patient.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.entity.Patient;
import com.patient.service.PatientService;
import com.patient.service.PatientServiceImpl;


@RestController
@RequestMapping("/api")
public class PatientRestController {

	// autowire the CustomerService
	@Autowired
	private PatientService patientService;
	
	// add mapping for GET /customers
	@GetMapping("/patient")
	public List<Patient> getCustomers() {
		
		return patientService.getPatient();
		
	}
	@GetMapping("/patient/{id}")
	public Patient getCustomerbyId(@PathVariable int id)
	{
		Patient patient =   patientService.getPatient(id);
		return patient;
	}
	@PostMapping("/patient/save")
	public Patient savePatient(@RequestBody Patient patient)
	{
		patient.setId(0);
		 patientService.savePatient(patient);
		 return patient;
		
	}	
	
	@PutMapping("/patient/update")
	public Patient updatePatient(@RequestBody Patient patient)
	{
		patientService.savePatient(patient);
		return patient;
	}
	
	@DeleteMapping("/patient/delete/{id}")
	public void deletePatient(@PathVariable int id)
	{
		patientService.deletePatient(id);
		
	}
	
		
	
}


















