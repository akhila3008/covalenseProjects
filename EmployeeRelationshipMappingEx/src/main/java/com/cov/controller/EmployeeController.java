package com.cov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cov.beans.Department;
import com.cov.beans.Employee;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.service.DepartmentService;
import com.cov.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "regEmp", method = RequestMethod.GET)
	public ModelAndView newEmployee() {
		ModelAndView modelandview = new ModelAndView("regEmployee", "employee", new Employee());
		modelandview.addObject("departmentService",departmentService);
		return modelandview;
	}

	@RequestMapping(value = "regEmp", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) throws InvalidEmployeeIdException {
		System.out.println("Employee to be inserted: "+employee);
		System.out.println("Department:"+employee.getDepartment());
		ModelAndView modelandview = new ModelAndView("employeeList");
		employeeService.save(employee);
		modelandview.addObject("employee", employeeService.findAll());
		return modelandview;
	}

	@RequestMapping(value="getEmps",method = RequestMethod.GET)
	public ModelAndView findAll()  throws InvalidEmployeeIdException {
		ModelAndView modelandview = new ModelAndView("employeeList");
		List<Employee> employees = employeeService.findAll();
		List<Department> departments = departmentService.findAll();
		modelandview.addObject("employee", employees);
		modelandview.addObject("departments",departments);
		modelandview.addObject("departmentService",departmentService);
		modelandview.addObject("department",new Department());
		modelandview.addObject("employeeService", employeeService);
		return modelandview;
	}
	
	@RequestMapping(value ="editEmp", method = RequestMethod.GET)
	public ModelAndView editEmp(@RequestParam int id) throws InvalidEmployeeIdException {
		Employee empToEdit = employeeService.findById(id);
	ModelAndView modelandview = new ModelAndView("showEditEmp", "empToEdit", empToEdit);
	modelandview.addObject("departmentService", departmentService);
	return modelandview;
	}
	
	@RequestMapping(value="updateEmp",method=RequestMethod.POST)
	public ModelAndView updateEdit(@ModelAttribute("empToEdit") Employee employee) throws InvalidEmployeeIdException {
	employeeService.update(employee);
	ModelAndView modelandview=new ModelAndView("redirect:"+ "getEmps");
	System.out.println("Employee update successful with id:"+employee.getId());
	return modelandview;

	}

	@RequestMapping(value= "deleteEmp")
	public ModelAndView deleteEmp(@RequestParam int id) throws InvalidEmployeeIdException {
		employeeService.delete(id);
		ModelAndView modelandview = new ModelAndView("redirect:"+"getEmps");
		
		return modelandview;
	}
	
	@RequestMapping(value="getAllEmp",method = RequestMethod.POST)
	public ModelAndView findAllEmployeeByDept(@RequestParam int deptid) throws InvalidDepartmentIdException {

	ModelAndView modelAndView=new ModelAndView("showEmployeeByDept");
	modelAndView.addObject("departmentService", departmentService);
	List<Employee> employees=employeeService.findAllByDeptno(deptid);
	modelAndView.addObject("employees",employees);

	return modelAndView;

	}

}
