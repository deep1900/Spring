package com.doctor.rest;

import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.apache.tomcat.util.net.ApplicationBufferHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.entity.Doctor;
import com.doctor.entity.Speciality;
import com.doctor.service.DoctorService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api")
public class DoctorRestController {

	// autowire the CustomerService
	@Autowired
	private DoctorService doctorService;
	
	// add mapping for GET /customers
	@GetMapping("/doctor")
	public List<Doctor> getCustomers() {
		
		return doctorService.getDoctor();
		
	}
	@GetMapping("/doctor/{id}")
	public Doctor getCustomerbyId(@PathVariable int id)
	{
		Doctor doctor = doctorService.getDoctor(id);
		return doctor;
	}
	//@PostMapping("/doctor/save")
//	@RequestMapping(value="/doctor/save", method=RequestMethod.POST, consumes="application/json")
//	public Doctor savePatient(@RequestParam(required=false, name="first_name") String fname, @RequestParam(required=false, name="last_name") String lname,
//			@RequestParam(name="speciality") String speciality) 
	@PostMapping("/doctor/save")
	public Doctor savePatient(@RequestBody Doctor doctor)
	{
		
	//	doctor.setId(0);
//		Doctor d = new Doctor("Deep", "Patel");
//		Speciality s= new Speciality("qwbdbbuw");
//		s.setDoctor(d);
//		d.getspeciality().add(s);
		System.out.println(doctor);
		System.out.println(doctor.getSpeciality().toString());
		Doctor d = new Doctor();
		d.setFirst_name(doctor.getFirst_name());
		d.setLast_name(doctor.getLast_name());
		System.out.println(doctor.getSpeciality());
		Speciality s = new Speciality();
		System.out.println(doctor.getSpeciality());
		return d;
		
	}	
	
	@PutMapping("/doctor/update")
	public Doctor updatePatient(@RequestBody Doctor patient)
	{
		doctorService.saveDoctor(patient);
		return patient;
	}
	
	@DeleteMapping("/doctor/delete/{id}")
	public void deletePatient(@PathVariable int id)
	{
		doctorService.deleteDoctor(id);
		
	}
	
		
	
}


















