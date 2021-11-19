package com.cov;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cov.beans.Department;
import com.cov.beans.Employee;
import com.cov.service.DepartmentService;
import com.cov.service.EmployeeService;

@SpringBootApplication
public class EmployeeRelationshipMappingExApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt =
				SpringApplication.run(EmployeeRelationshipMappingExApplication.class, args);
	
	Department department1 = new Department(1,"Sales");
	Department department2 = new Department(2,"Production");
	Department department3 = new Department(3,"Administration");
	Department department4 = new Department(4,"Human Resources");
	
	
	Employee employee1 = new Employee(101,"Akhila",department1);
	Employee employee2 = new Employee(102,"Preeti",department1);
	Employee employee3 = new Employee(103,"Hasini",department2);
	Employee employee4 = new Employee(104,"Sneha",department2);
	Employee employee5 = new Employee(105,"Niharika",department3);
	Employee employee6 = new Employee(106,"Manasa",department3);
	Employee employee7 = new Employee(107,"Sreeshma",department4);
	Employee employee8 = new Employee(108,"Nikhitha",department4);
	
	
	List<Employee> employees1= new ArrayList<>();
	List<Employee> employees2= new ArrayList<>();
	
	employees1.add(employee1);
	employees1.add(employee2);
	employees1.add(employee3);
	employees1.add(employee4);
	
	
	
	employees2.add(employee5);
	employees2.add(employee6);
	employees2.add(employee7);
	employees2.add(employee8);

	
	
	
	EmployeeService employeeService = ctxt.getBean(EmployeeService.class);
	DepartmentService departmentService = ctxt.getBean(DepartmentService.class);
	
	departmentService.save(department1);
	departmentService.save(department2);
	departmentService.save(department3);
	departmentService.save(department4);
	
	employeeService.save(employee1);
	employeeService.save(employee2);
	employeeService.save(employee3);
	employeeService.save(employee4);
	employeeService.save(employee5);
	employeeService.save(employee6);
    employeeService.save(employee7);
	employeeService.save(employee8);
	
	
		
 }

}
