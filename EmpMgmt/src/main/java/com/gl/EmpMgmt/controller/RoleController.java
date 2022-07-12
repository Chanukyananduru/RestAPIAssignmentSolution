package com.gl.EmpMgmt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.gl.EmpMgmt.entity.Employee;
import com.gl.EmpMgmt.entity.Role;
import com.gl.EmpMgmt.service.EmployeeService;
import com.gl.EmpMgmt.service.RoleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class RoleController {

	@Autowired
	private RoleServices roleService;

	@GetMapping("/roles")
	public ResponseEntity<List<Role>> getAllRoles() {
		return ResponseEntity.ok().body(roleService.getAllRoles());
	}


	@PostMapping("/roles")
	public ResponseEntity<Role> createRole(@RequestBody Role role) {
		return ResponseEntity.ok().body(this.roleService.createRole(role));
	}

	

}