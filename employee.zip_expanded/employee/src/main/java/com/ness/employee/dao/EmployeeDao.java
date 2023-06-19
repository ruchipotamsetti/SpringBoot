package com.ness.employee.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ness.employee.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>{

	public List<Employee> findByEmpName(String employeeName);
	public List<Employee> findByDepartment(String department);
	public List<Employee> findByDepartmentOrCity(String department, String city);
	public List<Employee> findBySalaryGreaterThan(int salary);
	
}
