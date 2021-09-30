package com.nagarro.mvcspringboot.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long employeeCode;
	private String employeeName;
	private String location;
	private String email;
	private String dob;


	public EmployeeModel(Long employeeCode, String employeeName, String location, String email, String dob) {
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.location = location;
		this.email = email;
		this.dob = dob;
	}

	public EmployeeModel() {
	}

	public Long getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
}
