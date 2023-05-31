package com.microservice.departmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.departmentservice.dto.DepartmentDto;
import com.microservice.departmentservice.entity.Department;
import com.microservice.departmentservice.mapper.DepartmentMapper;
import com.microservice.departmentservice.repository.DepartmentRepository;
import com.microservice.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		// convert departmentDto to departmentJPA Entity

		Department department = DepartmentMapper.mapToDepartment(departmentDto);

		Department savedDept = departmentRepository.save(department);

		DepartmentDto saveDeptDto = DepartmentMapper.mapToDepartmentDto(savedDept);
		return saveDeptDto;

	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		// TODO Auto-generated method stub
		Department department = departmentRepository.findDepartmentByDepartmentCode(code);

		DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

		return departmentDto;
	}

}
