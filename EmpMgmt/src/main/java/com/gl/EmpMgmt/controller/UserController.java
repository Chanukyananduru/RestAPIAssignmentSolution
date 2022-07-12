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
import com.gl.EmpMgmt.entity.User;
import com.gl.EmpMgmt.service.EmployeeService;
import com.gl.EmpMgmt.service.RoleServices;
import com.gl.EmpMgmt.service.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class UserController {

	@Autowired
	private UserServices userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUserrs() {
		return ResponseEntity.ok().body(userService.getAllUsers());
	}


	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok().body(this.userService.createUser(user));
	}

	

}