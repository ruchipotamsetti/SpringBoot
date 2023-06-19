package com.ness.employee.service;

import java.util.List;

import com.ness.employee.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public Employee getEmployeeById(int employeeId);
	public List<Employee> getEmployeeByName(String employeeName);
	public List<Employee> getAllEmployees();
	public Employee deleteEmployee(int employeeId);
	public Employee updateEmployee(Employee employee, int empId);
	public List<Employee> getEmployeeByDept(String employeeDpt);
	public List<Employee> getEmployeeByDeptOrCity(String employeeDpt, String city);
	public List<Employee> getEmployeeSalaryGreaterThan(int salary);
}
