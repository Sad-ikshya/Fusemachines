package com.fuse.bankManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.bankManagementSystem.dtos.UserLoginDto;
import com.fuse.bankManagementSystem.services.UserLoginService;

@RestController
@RequestMapping
public class UserLoginController {
	@Autowired
	private UserLoginService userLoginService;

	@PostMapping("/register")
	public ResponseEntity<UserLoginDto> saveUserLogin(@RequestBody UserLoginDto userLogin) {
		return new ResponseEntity<UserLoginDto>(userLoginService.saveUserLogin(userLogin), HttpStatus.OK);
	}
}
