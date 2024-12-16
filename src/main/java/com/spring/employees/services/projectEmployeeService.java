package com.spring.employees.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.employees.model.employeeModel;
import com.spring.employees.model.projectEmployeeModel;

@Service
public interface projectEmployeeService {

	List<projectEmployeeModel> getAllProjects();

	projectEmployeeModel getprojectByid(Long project_id);

	projectEmployeeModel postproject(projectEmployeeModel project);

	void deleteproject(Long project_id);

	projectEmployeeModel putproject(Long project_id, projectEmployeeModel project);
	

}
