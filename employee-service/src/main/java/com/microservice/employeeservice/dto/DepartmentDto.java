package com.microservice.employeeservice.dto;

public class DepartmentDto {

	private Long id;
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;
	
	
	public DepartmentDto() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDepartmentDescription() {
		return departmentDescription;
	}


	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}


	public String getDepartmentCode() {
		return departmentCode;
	}


	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}


	public DepartmentDto(Long id, String departmentName, String departmentDescription, String departmentCode) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.departmentCode = departmentCode;
	}
	
	
}
