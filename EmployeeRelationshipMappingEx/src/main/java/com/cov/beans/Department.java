package com.cov.beans;

import java.util.ArrayList;
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
	int id;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    public List<Employee> employees = new ArrayList<>();

	public Department(int id) {
		super();
		this.id = id;
		
		
		
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id =id;
	}

	@Override
	public String toString() {
		return "Department [id=" + id +"]";
	}
	
	

}
