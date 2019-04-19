package com.patient.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.patient.entity.Patient;

import org.hibernate.SessionFactory;
@Component
public class PatientDaoImpl implements PatientDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Patient> getPatient() {
		// get the current hibernate session
				//Session currentSession = sessionFactory.getCurrentSession();
				Session curruntSession = sessionFactory.getCurrentSession();
						
				// create a query  ... sort by last name
				Query<Patient> theQuery = 
						curruntSession.createQuery("from Patient",
													Patient.class);
				
				// execute query and get result list
				List<Patient> patients = theQuery.getResultList();
						
				// return the results		
				return patients;
	}

	@Override
	public Patient getPatientById(int id) {
		Session curruntSession = sessionFactory.getCurrentSession();
		Patient patient = curruntSession.get(Patient.class, id);
		
		
		return patient;
	}

	@Override
	public void savePatient(Patient patient) {
		Session curruntSession = sessionFactory.getCurrentSession();
		curruntSession.save(patient);

	}

	@Override
	public void deletePatient(int id) {
		Session curruntSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				curruntSession.createQuery("delete from Patient where id=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();		

	}

}
