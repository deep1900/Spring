package com.doctor.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="doctor")
public class Doctor implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="First_Name")
	private String first_name;
	@Column(name="Last_Name")
	private String last_name;
	
	@OneToMany(mappedBy="doctor", cascade=CascadeType.ALL)
	private List <Speciality> speciality = new ArrayList<Speciality>();

	
	public Doctor() {
	}
	
	
	
	public Doctor(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
	}



	public int getId() {
		return id;
	}
	public void setId(int pid) {
		this.id = pid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	public List<Speciality> getSpeciality() {
		return speciality;
	}
	public void setSpeciality(List<Speciality> speciality) {
		this.speciality = speciality;
	}



	@Override
	public String toString() {
		return "Doctor [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", speciality="
				+ speciality + "]";
	}
	
	
	

}
