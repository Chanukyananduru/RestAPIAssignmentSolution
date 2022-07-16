package com.gl.EmpMgmt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.gl.EmpMgmt.entity.Employee;
import com.gl.EmpMgmt.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class EmpController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok().body(employeeService.getAllEmployees());
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		employee.setId(id);
		return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
	}

	@DeleteMapping("/employees/{id}")
	public HttpStatus deleteEmployee(@PathVariable int id) {
		this.employeeService.deleteEmployee(id);
		return HttpStatus.OK;
	}

	@GetMapping("/employees/sort/asc")
	public ResponseEntity<List<Employee>> AscSortByFirstName() {
		return ResponseEntity.ok().body(employeeService.AscSortEmployeesByFirstName());
	}

	@GetMapping("/employees/sort/desc")
	public ResponseEntity<List<Employee>> DescSortByFirstName() {
		return ResponseEntity.ok().body(employeeService.DescSortEmployeesByFirstName());
	}

	@GetMapping("/employees/sort")
	public ResponseEntity<List<Employee>> SortByFirstName(@RequestParam("order") String order) {

		return ResponseEntity.ok().body(employeeService.SortEmployeesByFirstName(order));
	}

	@GetMapping("/employees/search")
	public ResponseEntity<List<Employee>> searchEmployees(@RequestParam("query") String query) {
		return ResponseEntity.ok(employeeService.searchEmployees(query));
	}

}