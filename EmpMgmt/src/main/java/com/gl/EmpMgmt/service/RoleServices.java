package com.gl.EmpMgmt.service;

import java.util.List;

import com.gl.EmpMgmt.entity.Employee;
import com.gl.EmpMgmt.entity.Role;
import com.gl.EmpMgmt.entity.User;

public interface RoleServices {
	
	Role createRole(Role role);
	List<Role> getAllRoles();


}
