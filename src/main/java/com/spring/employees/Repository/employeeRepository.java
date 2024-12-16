package com.spring.employees.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.employees.model.employeeModel;

@Repository
public interface employeeRepository extends JpaRepository<employeeModel, Long>{

}
