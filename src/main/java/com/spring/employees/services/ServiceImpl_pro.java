package com.spring.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employees.Repository.projectEmployeeRepository;
import com.spring.employees.model.employeeModel;
import com.spring.employees.model.projectEmployeeModel;

@Service
public class ServiceImpl_pro implements projectEmployeeService {
	@Autowired
	private projectEmployeeRepository ProjectEmployeeRepository;
	
	@Autowired
	private  employeeServices EmployeeServices;

	public ServiceImpl_pro(projectEmployeeRepository ProjectEmployeeRepository, employeeServices EmployeeServices)
	{
		this.ProjectEmployeeRepository =ProjectEmployeeRepository;
		this.EmployeeServices = EmployeeServices;
	}
	
	@Override
	public List<projectEmployeeModel> getAllProjects() {
		System.out.println("projects");
		

		return ProjectEmployeeRepository.findAll();
	}

	@Override
	public projectEmployeeModel getprojectByid(Long project_id) {
		// TODO Auto-generated method stub
		return ProjectEmployeeRepository.findById(project_id)
				.orElseThrow(() -> new RuntimeException("Project not found with id :" +project_id));
	}

	@Override
	public projectEmployeeModel postproject(projectEmployeeModel project) {
		// TODO Auto-generated method stub
		Long employeeId = project.getEmployee_id();
	    employeeModel employee = EmployeeServices.getEmployeeById(employeeId);
	    
	    //set employee details
	    project.setEmployee_id(employee.getEmployee_id());
	    project.setName(employee.getName());
		return ProjectEmployeeRepository.save(project) ;
	}

	@Override
	public void deleteproject(Long project_id) {
		// TODO Auto-generated method stub
		if(!ProjectEmployeeRepository.existsById(project_id))
		{
			throw new RuntimeException("Project not found");
		}
		
		ProjectEmployeeRepository.deleteById(project_id);
		
	}

	@Override
	public projectEmployeeModel putproject(Long project_id, projectEmployeeModel project) {
		// TODO Auto-generated method stub
		projectEmployeeModel existingProject = ProjectEmployeeRepository.findById(project_id)
				.orElseThrow(() -> new RuntimeException ("Project is not found with ID :" +project_id));
		//fetch employee by employee_id
		Long employeeId = project.getEmployee_id();
	    employeeModel employee = EmployeeServices.getEmployeeById(employeeId);

		existingProject.setProject_name(project.getProject_name());
		existingProject.setEmployee_id(employee.getEmployee_id());
		existingProject.setName(employee.getName());
		existingProject.setRole(project.getRole());
		existingProject.setStartDate(project.getStartDate());
		existingProject.setEndDate(project.getEndDate());
		existingProject.setStatus(project.getStatus());
		return ProjectEmployeeRepository.save(project);
	}

	

}
