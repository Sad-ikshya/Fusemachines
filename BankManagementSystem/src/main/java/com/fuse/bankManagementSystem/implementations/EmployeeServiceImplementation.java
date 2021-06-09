package com.fuse.bankManagementSystem.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fuse.bankManagementSystem.dtos.EmployeeDto;
import com.fuse.bankManagementSystem.entities.EmployeeEntity;
import com.fuse.bankManagementSystem.entities.Post;
import com.fuse.bankManagementSystem.repositories.EmployeeRepository;
import com.fuse.bankManagementSystem.services.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Page<EmployeeDto> getAllEmployee(int page, int size, String sortBy) {
		Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
		Page<EmployeeEntity> employee = employeeRepository.findAll(pageRequest);
		List<EmployeeDto> employeeDtoList = new ArrayList<>();
		for (EmployeeEntity e : employee) {
			EmployeeDto employeeDto = EmployeeDto.builder().id(e.getId()).firstName(e.getFirstName())
					.middleName(e.getMiddleName()).lastName(e.getLastName()).phoneNumber(e.getPhoneNumber())
					.address(e.getAddress()).post(e.getPost()).salary(e.getSalary()).email(e.getEmail()).build();

			employeeDtoList.add(employeeDto);

		}
		Page<EmployeeDto> pagedData = new PageImpl<>(employeeDtoList);
		return pagedData;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employee) {
		EmployeeEntity employeeEntity = EmployeeEntity.builder().id(employee.getId()).firstName(employee.getFirstName())
				.middleName(employee.getMiddleName()).lastName(employee.getLastName())
				.phoneNumber(employee.getPhoneNumber()).address(employee.getAddress()).post(employee.getPost())
				.salary(employee.getSalary()).email(employee.getEmail()).build();

		employeeEntity = employeeRepository.save(employeeEntity);
		employee.setId(employeeEntity.getId());
		return employee;
	}

	@Override
	public EmployeeDto getEmployeeById(String id) {
		EmployeeEntity employee = employeeRepository.findById(id).get();
		return EmployeeDto.builder().id(employee.getId()).firstName(employee.getFirstName())
				.middleName(employee.getMiddleName()).lastName(employee.getLastName())
				.phoneNumber(employee.getPhoneNumber()).address(employee.getAddress()).post(employee.getPost())
				.salary(employee.getSalary()).email(employee.getEmail()).build();

	}

	@Override
	public EmployeeDto updateEmployee(String id, EmployeeDto employee) {
		EmployeeEntity employeeEntity = EmployeeEntity.builder().id(id).firstName(employee.getFirstName())
				.middleName(employee.getMiddleName()).lastName(employee.getLastName())
				.phoneNumber(employee.getPhoneNumber()).address(employee.getAddress()).post(employee.getPost())
				.salary(employee.getSalary()).email(employee.getEmail()).build();

		employeeEntity = employeeRepository.save(employeeEntity);
		employee.setId(employeeEntity.getId());
		return employee;
	}

	@Override
	public void deleteEmployee(String id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public Page<EmployeeDto> getEmployeeByPost(Post post, int page, int size, String sortBy) {
		Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
		Page<EmployeeEntity> employee = employeeRepository.findByPost(post, pageRequest);
		List<EmployeeDto> employeeDtoList = new ArrayList<>();
		for (EmployeeEntity e : employee) {
			EmployeeDto employeeDto = EmployeeDto.builder().id(e.getId()).firstName(e.getFirstName())
					.middleName(e.getMiddleName()).lastName(e.getLastName()).phoneNumber(e.getPhoneNumber())
					.address(e.getAddress()).post(e.getPost()).salary(e.getSalary()).email(e.getEmail()).build();

			employeeDtoList.add(employeeDto);
		}
		Page<EmployeeDto> pagedData = new PageImpl<>(employeeDtoList);
		return pagedData;
	}

}
