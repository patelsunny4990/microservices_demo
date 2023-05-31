package com.microservice.employeeservice.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.employeeservice.dto.DepartmentDto;



@FeignClient(name ="DEPARTMENT-SERVICE" )
public interface APIClient {

	@GetMapping("/api/departments/{code}")
	 DepartmentDto getDepartmentByCode(@PathVariable("code") String code);
}
