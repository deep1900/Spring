package com.doctor.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity()
@Table(name="speciality")
public class Speciality  implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sid")
	private int id;
	@Column(name="Speciality_Name")
	@JsonProperty("specuality_Name")
	private String speciality_Name;
	
	@ManyToOne()
	@JoinColumn(name="doctor")
	private Doctor doctor;
	
	
	
	public Speciality() {
	}
	public Speciality(String speciality_Name) {
	
		this.speciality_Name = speciality_Name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpeciality_Name() {
		return speciality_Name;
	}
	public void setSpeciality_Name(String speciality_Name) {
		this.speciality_Name = speciality_Name;
	}
	

	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		return "Speciality [id=" + id + ", speciality_Name=" + speciality_Name + ", doctor=" + doctor + "]";
	}
	
	
	
	
	

}
