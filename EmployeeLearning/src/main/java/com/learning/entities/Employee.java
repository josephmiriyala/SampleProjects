package com.learning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(EmployeeId.class)
public class Employee {
	@Id
	private String employeeId;
	@Id
	private String employeeName;
	private boolean isPresented;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeeId, String employeeName, boolean isPresented) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.isPresented = isPresented;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public boolean getIsPresented() {
		return isPresented;
	}
	public void setIsPresented(boolean isPresented) {
		this.isPresented = isPresented;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", isPresented=" + isPresented
				+ "]";
	}
	
}
