package com.gl.EmpMgmt.repository;

import com.gl.EmpMgmt.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
