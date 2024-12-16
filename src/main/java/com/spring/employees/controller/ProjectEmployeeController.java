package com.spring.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employees.model.employeeModel;
import com.spring.employees.model.projectEmployeeModel;
import com.spring.employees.services.projectEmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectEmployeeController {
	
	@Autowired
	private final projectEmployeeService ProjectEmployeeService;
	
	public ProjectEmployeeController(projectEmployeeService ProjectEmployeeService)
	{
		this.ProjectEmployeeService = ProjectEmployeeService;
	}
	
	
	@GetMapping("/projs")
	public ResponseEntity <List<projectEmployeeModel>> getAllProjects()
	{
		List<projectEmployeeModel> projects = ProjectEmployeeService.getAllProjects();
		return ResponseEntity.ok(projects);
		
	}
	
	@GetMapping("/projs/{project_id}")
	public ResponseEntity<projectEmployeeModel> getprojectByid(@PathVariable Long project_id )
	{
		projectEmployeeModel getproject = ProjectEmployeeService.getprojectByid(project_id);
		if(getproject != null)
		{
			return ResponseEntity.ok(getproject);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping("/projs/add_projs")
	public ResponseEntity<projectEmployeeModel> postproject (@RequestBody projectEmployeeModel project )
	{
		projectEmployeeModel postedproject = ProjectEmployeeService.postproject(project);
		return ResponseEntity.status(HttpStatus.CREATED).body(postedproject);
	}
	
	
	@DeleteMapping("/projs/dele/{project_id}")
	public ResponseEntity<projectEmployeeModel> deleteproject (@PathVariable Long project_id )
	{
		try {
			ProjectEmployeeService.deleteproject(project_id);
			return ResponseEntity.ok().build();
		}catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@PutMapping("/projs/put_projs/{project_id}")
	public ResponseEntity <projectEmployeeModel> putproject(@PathVariable Long project_id , @RequestBody projectEmployeeModel project )
	{
		try {
			projectEmployeeModel existingProject = ProjectEmployeeService.putproject(project_id , project);
			return ResponseEntity.ok(project);
		}catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}


}
