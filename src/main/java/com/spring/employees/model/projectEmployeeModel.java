package com.spring.employees.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_employee_model")
public class projectEmployeeModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long project_id;
	private String project_name;
	private Long employee_id;
	private String Name;
	private String Role;
	@Column(name ="start_date")
	private LocalDate startDate; 
	@Column(name ="end_date")

    private LocalDate endDate; 
    private String status;
	public projectEmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public projectEmployeeModel(long project_id, String project_name, Long employee_id, String name, String role,
			LocalDate startDate, LocalDate endDate, String status) {
		super();
		this.project_id = project_id;
		this.project_name = project_name;
		this.employee_id = employee_id;
		Name = name;
		Role = role;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	
	public long getProject_id() {
		return project_id;
	}
	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public Long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "projectEmployee [project_id=" + project_id + ", project_name=" + project_name + ", employee_id="
				+ employee_id + ", Name=" + Name + ", Role=" + Role + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + "]";
	}
	
	
    
	

}
