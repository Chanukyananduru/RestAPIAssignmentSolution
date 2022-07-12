package com.gl.EmpMgmt.service;

import java.util.List;

import com.gl.EmpMgmt.entity.Role;
import com.gl.EmpMgmt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServicesImpl implements RoleServices {

	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		return this.roleRepository.findAll();
	}

}
