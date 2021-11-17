package com.cov.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cov.beans.Department;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> findAll() {
		// List<Employee> employee=new ArrayList<Employee>();
		return departmentRepository.findAll();
		// return employee;
	}

	public Department findById(String deptid) throws InvalidDepartmentIdException {
		Optional<Department> deptOptional = departmentRepository.findById(deptid);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException("Department Id " + deptid + " not existing in repository");
		}
		return deptOptional.get();
	}

	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	public Department update(Department department) throws InvalidDepartmentIdException {
		Optional<Department> deptOptional = departmentRepository.findById(department.getDeptid());
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException(
					"Department Id" + department.getDeptid() + "not existing in reposiotory");
		}
		return departmentRepository.save(department);
	}

	public Department delete(String deptid) throws InvalidDepartmentIdException {
		Optional<Department> deptOptional = departmentRepository.findById(deptid);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException("Department Id " + deptid + "not existing in repository");
		}
		Department department = deptOptional.get();
		return department;
	}
}
