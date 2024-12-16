package com.spring.employees.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.employees.model.projectEmployeeModel;

@Repository
public interface projectEmployeeRepository extends JpaRepository<projectEmployeeModel, Long>{

}
