package com.trainingapps.empms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.empms.entity.Employee;
import com.trainingapps.empms.service.EmployeeService;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/get/byid/{id}")
	public Employee fetchEmployee(@PathVariable int id) {
		Employee employee=empService.getEmployee(id);
		return employee;
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee requestData) {
		Employee saved=empService.addEmployee(requestData);
	   return saved;
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee requestData) {
		Employee updated=empService.updateEmployee(requestData);
		return updated;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		empService.deleteEmployee(id);
		return "deleted employee "+id;
	}
	
}
