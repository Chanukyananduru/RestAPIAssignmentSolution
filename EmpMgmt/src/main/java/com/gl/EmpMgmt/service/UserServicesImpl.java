package com.gl.EmpMgmt.service;

import java.util.List;

import com.gl.EmpMgmt.entity.Role;
import com.gl.EmpMgmt.entity.User;
import com.gl.EmpMgmt.repository.EmpRepository;
import com.gl.EmpMgmt.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

	
	@Autowired
	private UserRepository userRepository;
	


	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}



	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

}
