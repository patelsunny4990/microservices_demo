package com.microservice.employeeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.employeeservice.dto.APIResponseDto;
import com.microservice.employeeservice.dto.DepartmentDto;
import com.microservice.employeeservice.dto.EmployeeDto;
import com.microservice.employeeservice.entity.Employee;
import com.microservice.employeeservice.mapper.EmployeeMapper;
import com.microservice.employeeservice.repository.EmployeeRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private APIClient apiClient;

	public EmployeeServiceImpl() {
		super();
	}

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, APIClient apiClient) {
		super();
		this.employeeRepository = employeeRepository;
		this.apiClient = apiClient;
	}

//	public EmployeeServiceImpl(APIClient apiClient) {
//		super();
//		this.apiClient = apiClient;
//	}
//
//	
//	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//		super();
//		this.employeeRepository = employeeRepository;
//	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

		Employee savedEmployee = employeeRepository.save(employee);

		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);

		return savedEmployeeDto;

	}

	@Override
	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	public APIResponseDto getEmployee(Long id) {

		Employee getEmployee = employeeRepository.findById(id).get();

		DepartmentDto departmentDto = apiClient.getDepartmentByCode(getEmployee.getDepartmentCode());

		EmployeeDto getEmployeeDto = EmployeeMapper.mapToEmployeeDto(getEmployee);

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setDepartmentDto(departmentDto);
		apiResponseDto.setEmployeeDto(getEmployeeDto);

		return apiResponseDto;
	}

	public APIResponseDto getDefaultDepartment(Long id, Exception exception) {
		Employee getEmployee = employeeRepository.findById(id).get();

		DepartmentDto departmentDto = new DepartmentDto(5L, "Test", "In case of Failure", "404");

		EmployeeDto getEmployeeDto = EmployeeMapper.mapToEmployeeDto(getEmployee);

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setDepartmentDto(departmentDto);
		apiResponseDto.setEmployeeDto(getEmployeeDto);

		return apiResponseDto;
	}

}
