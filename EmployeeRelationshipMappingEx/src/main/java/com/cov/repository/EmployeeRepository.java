package com.cov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cov.beans.Department;
import com.cov.beans.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//@Query("SELECT emp from Employee emp where emp.deptno=1")
	List<Employee> findByDepartment(Department department);
}
