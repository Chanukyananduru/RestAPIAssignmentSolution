package com.gl.EmpMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.EmpMgmt.entity.*;

public interface RoleRepository extends JpaRepository<Role,Long> {

}