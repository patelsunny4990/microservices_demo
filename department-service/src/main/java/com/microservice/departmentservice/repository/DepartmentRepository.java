package com.microservice.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findDepartmentByDepartmentCode(String departmentCode);
}
