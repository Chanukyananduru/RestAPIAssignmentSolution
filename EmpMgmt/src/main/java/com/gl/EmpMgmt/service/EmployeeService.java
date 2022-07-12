package com.gl.EmpMgmt.service;

import java.util.List;

import com.gl.EmpMgmt.entity.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(int id);

	void deleteEmployee (int id);
	

}
