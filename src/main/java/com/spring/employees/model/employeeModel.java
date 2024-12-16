package com.spring.employees.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class employeeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employee_id;
	private String Name;
	private String email_id;
	private long contact;
	private String Department;
	private String Role;
	private String Actions;
	public employeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public employeeModel(long employee_id, String name, String email_id, long contact, String department, String role,
			String actions) {
		super();
		this.employee_id = employee_id;
		Name = name;
		this.email_id = email_id;
		this.contact = contact;
		Department = department;
		Role = role;
		Actions = actions;
	}
	public long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getActions() {
		return Actions;
	}
	public void setActions(String actions) {
		Actions = actions;
	}
	
	
	
	
	
	
}
