package com.trainingapps.empms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trainingapps.empms.entity.Employee;
import com.trainingapps.empms.exceptions.EmployeeNotFoundException;
import com.trainingapps.empms.repository.IEmployeeRepository;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private IEmployeeRepository empRepository;

	@Override
	public List<Employee> getEmployees() {
		List<Employee> list = empRepository.findAll();
		return list;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		employee = empRepository.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee change) {
		Employee found = getEmployee(change.getId());
		found.setEmployeeName(change.getEmployeeName());
		found.setAge(change.getAge());
		found.setDepartment(change.getDepartment());
		found = empRepository.save(found);
		return found;

	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> optional = empRepository.findById(id);
		if (!optional.isPresent()) {
			throw new EmployeeNotFoundException("employee not found by id=" + id);
		}
		Employee emp = optional.get();
		return emp;
	}

	@Override
	public void deleteEmployee(int id) {
		empRepository.deleteById(id);

	}

}
