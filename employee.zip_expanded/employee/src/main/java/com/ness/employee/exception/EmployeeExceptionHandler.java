package com.ness.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(EmployeeDoesNotExist.class)
	public ResponseEntity<String> employeeDoesNotExist(){
		return new ResponseEntity<String>("Employee not registered", HttpStatus.NOT_ACCEPTABLE);
		
	}

	@ExceptionHandler(EmployeeAlreadyExists.class)
	public ResponseEntity<String> employeeAlreadytExists(){
		return new ResponseEntity<String>("Employee is already registered", HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	

}
