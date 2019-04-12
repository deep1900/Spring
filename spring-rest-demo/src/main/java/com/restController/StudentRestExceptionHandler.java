package com.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler 
{
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponce> handleException(StudentNotFoundException exc)
	{
		
		StudentErrorResponce error = new StudentErrorResponce(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponce> handleException(Exception exc)
	{
		StudentErrorResponce error = new StudentErrorResponce(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
		
	}
	

}
