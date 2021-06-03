package com.fuse.financeManagement.controllers;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.financeManagement.models.User;
import com.fuse.financeManagement.services.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);

	}

	@PostMapping("/")
	public ResponseEntity<User> save(@RequestBody User user) throws MissingRequestHeaderException {
		if (user.getFullName().isEmpty())
			throw new MissingRequestHeaderException(null, null);

		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable BigInteger id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable BigInteger id, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(id, user), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable BigInteger id) {
		userService.deleteuser(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
