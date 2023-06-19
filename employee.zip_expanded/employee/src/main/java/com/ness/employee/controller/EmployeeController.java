package com.ness.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ness.employee.model.Employee;
import com.ness.employee.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("getbyid/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int employeeId){
		
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	@GetMapping("getbyname/{employeeName}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String employeeName){
		
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByName(employeeName), HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("{employeeId}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int employeeId){
		
		return new ResponseEntity<Employee>(employeeService.deleteEmployee(employeeId), HttpStatus.FOUND);
	}
	
	@PutMapping("{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int employeeId){
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.CREATED);
	}
	
	@GetMapping("getbydept/{employeeDept}")
	public ResponseEntity<List<Employee>> getEmployeeByDept(@PathVariable String employeeDept){
		
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByDept(employeeDept), HttpStatus.OK);
	}
	
	@GetMapping("getbydc/{employeeDept}/{city}")
	public ResponseEntity<List<Employee>> getEmployeeByDeptOrCity(@PathVariable String employeeDept, @PathVariable String city){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByDeptOrCity(employeeDept, city), HttpStatus.OK);
	}
	
	@GetMapping("getbysalary20k")
	public ResponseEntity<List<Employee>> getEmployeeSalaryGreaterThan20k(){
		
		int salary=20000;
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeSalaryGreaterThan(salary), HttpStatus.OK);
	}
	
	
	

}
