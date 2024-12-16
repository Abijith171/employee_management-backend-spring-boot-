package com.spring.employees.controller;

import java.util.List;

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
import com.spring.employees.services.employeeServices;

import jakarta.transaction.Transactional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Employeecontroller {
	
	private final employeeServices EmployeeServices;
	
		
	public Employeecontroller(employeeServices EmployeeServices ) {
        this.EmployeeServices = EmployeeServices;
        
    }
	

	@GetMapping("/emps")
	public ResponseEntity<List<employeeModel>> getAllEmployees()
	{
		List<employeeModel> employees = EmployeeServices.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> getEmployeeCount()
	{
		Long count = EmployeeServices.getEmployeeCount();
		return ResponseEntity.ok(count);
	}
	
	
	@GetMapping("/emps/{employee_id}")
	public ResponseEntity<employeeModel> getemployeeByid(@PathVariable Long employee_id , @RequestBody employeeModel employee)
	{
		employeeModel getemployeeByid = EmployeeServices.getemployeeByid(employee_id, employee);
		return ResponseEntity.ok(employee);
		
	}

	
	
	@PostMapping("/emps/add_emps")
	@Transactional
	public ResponseEntity<employeeModel> postemployee(@RequestBody employeeModel employee)
	{
		employeeModel postedemployee = EmployeeServices.postemployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(postedemployee);
	}
	
	
	@DeleteMapping("/{employee_id}")
	public ResponseEntity<employeeModel>  deleteemployee(@PathVariable Long employee_id)
	{
		try {
			EmployeeServices.deleteemployee(employee_id);
			return ResponseEntity.ok() .build();		
		}catch (RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@PutMapping("/emps/put_emps/{employee_id}")
	public ResponseEntity<employeeModel> putemployee(@PathVariable Long employee_id, @RequestBody employeeModel employee)
	{
		try {
			employeeModel putemployee = EmployeeServices.putemployee(employee_id, employee);
			return ResponseEntity.ok(employee);
		}catch (RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
}




















