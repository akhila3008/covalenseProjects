package com.cov.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String deptid;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    public List<Employee> employees;

	public Department(String deptid) {
		super();
		this.deptid = deptid;
		
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@Override
	public String toString() {
		return "Department [deptid=" + deptid + "]";
	}
	
	

}
