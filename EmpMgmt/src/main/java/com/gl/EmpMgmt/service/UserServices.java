package com.gl.EmpMgmt.service;

import java.util.List;

import com.gl.EmpMgmt.entity.Role;
import com.gl.EmpMgmt.entity.User;

public interface UserServices {
	
	User createUser(User user);
	List<User> getAllUsers();
}
