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

import com.fuse.bankManagementSystem.dtos.UserDto;
import com.fuse.bankManagementSystem.entities.Gender;
import com.fuse.bankManagementSystem.exceptionHandling.UserNotFoundException;
import com.fuse.bankManagementSystem.services.UserService;
import com.fuse.bankManagementSystem.utility.Response;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<Map<String, Object>> getAllUser(@RequestParam(defaultValue = "") String gender,
			@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "3") Integer size) throws UserNotFoundException {
		Response<UserDto> response = new Response<UserDto>();
		if (!gender.isEmpty()) {
			Page<UserDto> data = userService.findByGender(Gender.valueOf(gender), page, size, sortBy);
			if (data.isEmpty()) {
				throw new UserNotFoundException();
			}
			return response.getPageResponseEntity(data, HttpStatus.OK);
		}

		Page<UserDto> data = userService.getAllUser(page, size, sortBy);

		return response.getPageResponseEntity(data, HttpStatus.OK);

	}

	@PostMapping("/")
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user) {
		return new ResponseEntity<UserDto>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
		return new ResponseEntity<UserDto>(userService.getUserById(id), HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UserDto user) {
		return new ResponseEntity<UserDto>(userService.updateUser(id, user), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}

}
