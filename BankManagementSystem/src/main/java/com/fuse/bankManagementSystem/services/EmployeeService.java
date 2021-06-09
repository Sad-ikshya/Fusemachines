package com.fuse.bankManagementSystem.services;

import org.springframework.data.domain.Page;

import com.fuse.bankManagementSystem.dtos.EmployeeDto;
import com.fuse.bankManagementSystem.entities.Post;

public interface EmployeeService {
	public Page<EmployeeDto> getAllEmployee(int page, int size, String sortBy);

	public EmployeeDto saveEmployee(EmployeeDto employee);

	public EmployeeDto getEmployeeById(String id);

	public EmployeeDto updateEmployee(String id, EmployeeDto employee);

	public void deleteEmployee(String id);

	public Page<EmployeeDto> getEmployeeByPost(Post post, int page, int size, String sortBy);

}
