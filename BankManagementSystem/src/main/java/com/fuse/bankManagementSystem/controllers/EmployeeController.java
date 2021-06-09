package com.fuse.bankManagementSystem.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.bankManagementSystem.dtos.EmployeeDto;
import com.fuse.bankManagementSystem.entities.Post;
import com.fuse.bankManagementSystem.services.EmployeeService;
import com.fuse.bankManagementSystem.utility.Response;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public ResponseEntity<Map<String, Object>> getAllEmployee(@RequestParam(defaultValue = "") String post,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size,
			@RequestParam(defaultValue = "id") String sortBy) {
		Response<EmployeeDto> response = new Response<EmployeeDto>();
		if (!post.isEmpty()) {
			Page<EmployeeDto> pagedData = employeeService.getEmployeeByPost(Post.valueOf(post), page, size, sortBy);
			return response.getPageResponseEntity(pagedData, HttpStatus.OK);
		}
		return response.getPageResponseEntity(employeeService.getAllEmployee(page, size, sortBy), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employee) {
		return new ResponseEntity<EmployeeDto>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String id) {
		return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeById(id), HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> editEmployee(@PathVariable String id, @RequestBody EmployeeDto employee) {
		return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
