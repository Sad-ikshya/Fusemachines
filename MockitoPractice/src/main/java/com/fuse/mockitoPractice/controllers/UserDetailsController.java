package com.fuse.mockitoPractice.controllers;

import java.math.BigInteger;
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

import com.fuse.mockitoPractice.dtos.UserDetailsDto;
import com.fuse.mockitoPractice.services.UserDetailsService;

@RestController
@RequestMapping("/users")
public class UserDetailsController {
	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/")
	public ResponseEntity<List<UserDetailsDto>> getAllUsers() {
		return new ResponseEntity<List<UserDetailsDto>>(userDetailsService.getAllUsers(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<UserDetailsDto> addUser(@RequestBody UserDetailsDto userDetails) {
		return new ResponseEntity<UserDetailsDto>(userDetailsService.addUser(userDetails), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDetailsDto> getUserById(@PathVariable BigInteger id) {
		return new ResponseEntity<UserDetailsDto>(userDetailsService.getUserDetailsById(id), HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDetailsDto> updateUser(@PathVariable BigInteger id,
			@RequestBody UserDetailsDto userDetails) {
		return new ResponseEntity<UserDetailsDto>(userDetailsService.updateUser(id, userDetails), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable BigInteger id) {
		userDetailsService.deleteUser(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}