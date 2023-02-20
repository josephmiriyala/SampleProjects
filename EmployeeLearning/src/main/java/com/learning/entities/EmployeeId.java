package com.learning.entities;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String employeeId;
	private String employeeName;
	public EmployeeId(String employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	public EmployeeId() {
		super();
		// TODO Auto-generated constructor stub
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "EmployeeId [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(employeeId, employeeName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeId other = (EmployeeId) obj;
		return Objects.equals(employeeId, other.employeeId) && Objects.equals(employeeName, other.employeeName);
	}
	
	
}
