package com.cov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cov.beans.Department;
import com.cov.beans.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT emp from Employee emp where emp.department.id=?1")
	List<Employee> findAllEmployeeByDeptno(int deptno);
}
