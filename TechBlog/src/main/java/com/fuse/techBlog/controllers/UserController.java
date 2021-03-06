package com.fuse.techBlog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.techBlog.dtos.UserDto;
import com.fuse.techBlog.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser() {
		return new ResponseEntity<List<UserDto>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user) {
		System.out.print("hello=================================>");
		return new ResponseEntity<UserDto>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserByid(@PathVariable String id) {
		return new ResponseEntity<UserDto>(userService.getUserById(id), HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UserDto user) {
		System.out.println("New Test========================>" + user.getFirstName());
		return new ResponseEntity<UserDto>(userService.updateUser(id, user), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}
}
