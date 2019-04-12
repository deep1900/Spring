package com.restController;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController
{
	private List<Student> theStudents;
	@PostConstruct
	public void LoadData()
	{
		 theStudents = new ArrayList<>();
		theStudents.add(new Student("Deep", "Patel"));
		theStudents.add(new Student("Akash", "Patel"));
		theStudents.add(new Student("Shaunak", "Patadiya"));
		
	}
	//define an endpoint for "/student"
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		
		
		return theStudents;
	}
	
	//define endpoint for /student/{studentId}
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		//check the studentid against the list size
				if(studentId >= theStudents.size() || studentId<0)
				{
					throw new StudentNotFoundException("Student id is not Found :" +studentId);
					
				}
		
		return theStudents.get(studentId);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
