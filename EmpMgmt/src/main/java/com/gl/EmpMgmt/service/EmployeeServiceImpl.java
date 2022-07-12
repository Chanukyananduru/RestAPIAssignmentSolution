package com.gl.EmpMgmt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.gl.EmpMgmt.entity.Employee;
import com.gl.EmpMgmt.exception.ResourceNotFoundException;
import com.gl.EmpMgmt.repository.EmpRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Repository
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmpRepository empRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employeeDB = this.empRepository.findById(employee.getId());
		if (employeeDB.isPresent()) {
			Employee employeeUpdate = employeeDB.get();
			employeeUpdate.setId(employee.getId());
			employeeUpdate.setFirstName(employee.getFirstName());
			employeeUpdate.setLastName(employee.getLastName());
			employeeUpdate.setEmail(employee.getEmail());
			empRepository.save(employeeUpdate);
			return employeeUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id: " + employee.getId());
		}

	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.empRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> employeeDB = this.empRepository.findById(id);
		if (employeeDB.isPresent()) {
			return employeeDB.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + id);
		}
	}

	@Override
	public void deleteEmployee(int id) {
		Optional<Employee> employeeDB = this.empRepository.findById(id);
		if (employeeDB.isPresent()) {
			this.empRepository.delete(employeeDB.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + id);
		}

	}

}
