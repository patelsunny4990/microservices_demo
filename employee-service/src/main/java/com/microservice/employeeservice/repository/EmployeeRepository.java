package com.microservice.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
