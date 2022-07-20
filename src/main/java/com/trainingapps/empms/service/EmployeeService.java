package com.trainingapps.empms.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.trainingapps.empms.entity.Employee;

@Validated
public interface EmployeeService {
	List<Employee> getEmployees();

    Employee addEmployee(@Valid Employee employee);

    
	Employee getEmployee(@Min(1)int id);

	Employee updateEmployee(@Valid Employee change ) ;
	
	
	void deleteEmployee(@Min(1) int id);
	
}
