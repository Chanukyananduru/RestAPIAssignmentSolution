package com.gl.EmpMgmt.repository;

import java.util.List;

import com.gl.EmpMgmt.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT e FROM Employee e WHERE e.firstName LIKE CONCAT('%',:query, '%')")    
    public List<Employee> searchEmployees(String query);
}
