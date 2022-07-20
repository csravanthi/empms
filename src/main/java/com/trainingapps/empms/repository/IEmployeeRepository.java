package com.trainingapps.empms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingapps.empms.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

}
