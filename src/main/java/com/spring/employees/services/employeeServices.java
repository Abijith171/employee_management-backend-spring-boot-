package com.spring.employees.services;

import java.util.List;

import com.spring.employees.model.employeeModel;

public interface  employeeServices {
 
	List<employeeModel> getAllEmployees();

	employeeModel postemployee(employeeModel employee);

	void deleteemployee(Long employee_id);

	employeeModel putemployee(Long employee_id,employeeModel employee);
	
	employeeModel getEmployeeById(Long employee_id);
	
	employeeModel getemployeeByid (Long employee_id , employeeModel employee);


	Long getEmployeeCount();
}
