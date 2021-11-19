
package com.cov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cov.beans.Department;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.service.DepartmentService;
import com.cov.service.EmployeeService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "newDept", method = RequestMethod.GET)
	public ModelAndView newDepartment() {
		ModelAndView modelandview = new ModelAndView("newDepartment", "department", new Department());
		modelandview.addObject("employeeService", employeeService);
		return modelandview;
	}

	@RequestMapping(value = "newDept", method = RequestMethod.POST)
	public ModelAndView saveDepartment(@ModelAttribute Department department) throws InvalidDepartmentIdException {
		ModelAndView modelandview = new ModelAndView("saveDepartment");
		modelandview.addObject("department", departmentService.save(department));
		return modelandview;
	}

	@RequestMapping("getDepts")
	public ModelAndView findAll() {
		ModelAndView modelandview = new ModelAndView("employeeList", "department", departmentService.findAll());
		return modelandview;
	}

	@RequestMapping(value = "editDept", method = RequestMethod.GET)
	public ModelAndView editDept(@RequestParam int id) throws InvalidDepartmentIdException {
		Department deptToEdit = departmentService.findById(id);
		ModelAndView modelandview = new ModelAndView("showEditDept", "deptToEdit", deptToEdit);
		return modelandview;
	}

	@RequestMapping(value = "updateDept", method = RequestMethod.POST)
	public ModelAndView updateDept(@ModelAttribute("deptToEdit") Department department)
			throws InvalidDepartmentIdException {
		departmentService.update(department);
		ModelAndView modelAndView = new ModelAndView("redirect:" + "getDepts");
		System.out.println("department update successful with id:" + department.getId());
		return modelAndView;

	}

	@RequestMapping(value = "deleteDept",method = RequestMethod.POST )
	public ModelAndView deleteEmp(@RequestParam int id) throws InvalidDepartmentIdException {
		departmentService.delete(id);
		ModelAndView modelandview = new ModelAndView("redirect:" + "getDepts");
		return modelandview;
	}

}
