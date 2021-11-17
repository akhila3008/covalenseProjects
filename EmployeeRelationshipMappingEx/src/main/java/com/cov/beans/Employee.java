package com.cov.beans;

public class Employee {
	int id;
	String name;
	int deptno;
	public Employee(int id, String name, int deptno) {
		super();
		this.id = id;
		this.name = name;
		this.deptno = deptno;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deptno=" + deptno + "]";
	}
	

}
