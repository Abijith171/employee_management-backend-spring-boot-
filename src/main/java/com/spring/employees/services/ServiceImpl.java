package com.spring.employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employees.Repository.employeeRepository;
import com.spring.employees.model.employeeModel;


@Service
public class ServiceImpl implements employeeServices   {
	
@Autowired	
private employeeRepository employeeRepository; 


public ServiceImpl (employeeRepository employeeRepository )
{
	this.employeeRepository=employeeRepository;
	
}
	
	@Override
	public List<employeeModel> getAllEmployees()
	{
		return employeeRepository.findAll();
	}

	@Override
	public employeeModel postemployee(employeeModel employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public employeeModel putemployee(Long employee_id, employeeModel employee) {
		// TODO Auto-generated method stub
		
		employeeModel employee1 = employeeRepository.findById(employee_id)
				.orElseThrow(()-> new RuntimeException ("Employee is not found with ID:" +employee_id));
		employee.setName(employee.getName());
		employee.setEmployee_id(employee.getEmployee_id());
		employee.setEmail_id(employee.getEmail_id());
		employee.setContact(employee.getContact());
		employee.setDepartment(employee.getDepartment());
		employee.setRole(employee.getRole());
		employee.setActions(employee.getActions());
		
		
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteemployee(Long employee_id) {
		// TODO Auto-generated method stub
		if(!employeeRepository.existsById(employee_id))
		{
			throw new RuntimeException("Employee not found");
		}
		
		employeeRepository.deleteById(employee_id);
	}

	@Override
	public employeeModel getemployeeByid(Long employee_id, employeeModel employee) {
		// TODO Auto-generated method stub
		 return employeeRepository.findById(employee_id)
				 .orElseThrow(() -> new RuntimeException("Employee not found with id :" + employee_id));
	}

	@Override
	public employeeModel getEmployeeById(Long employee_id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(employee_id)
	            .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employee_id));
	}

	
	

	@Override
	public Long getEmployeeCount() {
		// TODO Auto-generated method stub
		return employeeRepository.count();
	};
	

	
	
	

	

}












