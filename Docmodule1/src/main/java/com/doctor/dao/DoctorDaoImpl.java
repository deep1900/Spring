package com.doctor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.doctor.entity.Doctor;

import org.hibernate.SessionFactory;

@Component
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Doctor> getDoctor() {
		Session curruntSession = sessionFactory.getCurrentSession();

		// create a query ...
		Query<Doctor> theQuery = curruntSession.createQuery("from Doctor d", Doctor.class);

		// execute query and get result list
		List<Doctor> patients = theQuery.getResultList();

		// return the results
		return patients;

	}

	public Doctor getDoctorbyId(int id) {
		Session curruntSession = sessionFactory.getCurrentSession();
		Doctor patient = curruntSession.get(Doctor.class, id);

		return patient;
	}

	public void saveDoctor(Doctor patient) {
		Session curruntSession = sessionFactory.getCurrentSession();
		curruntSession.save(patient);
	}

	public void deleteDoctor(int id) {
		Session curruntSession = sessionFactory.getCurrentSession();
		Query theQuery = curruntSession.createQuery("delete from Patient where id=:id");
		theQuery.setParameter("id", id);

		theQuery.executeUpdate();

	}
}