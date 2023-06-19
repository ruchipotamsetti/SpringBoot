package com.ness.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ness.employee.dao.EmployeeDao;
import com.ness.employee.exception.EmployeeAlreadyExists;
import com.ness.employee.exception.EmployeeDoesNotExist;
import com.ness.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> found = employeeDao.findById(employee.getEmpId());
		if(found.isPresent()) {
			throw new EmployeeAlreadyExists("Employee already exists");
		}
		return employeeDao.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeDao.findById(employeeId);
		
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new EmployeeDoesNotExist("Employee does not exist");
		}
	}

	@Override
	public List<Employee> getEmployeeByName(String employeeName) {
		// TODO Auto-generated method stub
		List<Employee> found = (List<Employee>) employeeDao.findByEmpName(employeeName);
		
		if(found.isEmpty()) {
			throw new EmployeeDoesNotExist("Employee does not exist");
		}
		return found;
	}

	@Override
	public Employee deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeDao.findById(employeeId);
		
		if(employee.isPresent()) {
			employeeDao.delete(employee.get());
			return employee.get();		
		}
		else {
			throw new EmployeeDoesNotExist("Employee does not exist");
		}
		
	}

	@Override
	public Employee updateEmployee(Employee employee, int empId) {
		// TODO Auto-generated method stub
		Optional<Employee> found=employeeDao.findById(employee.getEmpId());
		if(found.isPresent()) {
			employeeDao.save(employee);
			return employee;	
		}
		throw new EmployeeDoesNotExist("Employee does not exist");
	}

	@Override
	public List<Employee> getEmployeeByDept(String employeeDpt) {
		
		List<Employee> found = employeeDao.findByDepartment(employeeDpt);
		if(found.isEmpty()) {
			throw new EmployeeDoesNotExist("Employee does not exist");
		}
		return found;
	}

	@Override
	public List<Employee> getEmployeeByDeptOrCity(String employeeDpt, String city) {
		// TODO Auto-generated method stub
		
		List<Employee>found = employeeDao.findByDepartmentOrCity(employeeDpt, city);
		return found;
	}

	@Override
	public List<Employee> getEmployeeSalaryGreaterThan(int salary) {
		// TODO Auto-generated method stub
		List<Employee> found = employeeDao.findBySalaryGreaterThan(salary);
		return found;
	}

	
	
}
