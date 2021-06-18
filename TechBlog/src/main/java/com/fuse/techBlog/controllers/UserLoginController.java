package com.fuse.techBlog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.techBlog.dtos.UserLoginDto;
import com.fuse.techBlog.services.UserLoginService;

@RestController
@RequestMapping("/register")
public class UserLoginController {
	@Autowired
	private UserLoginService userLoginService;

	@PostMapping("/")
	public ResponseEntity<UserLoginDto> register(@RequestBody UserLoginDto userLogin) {

		return new ResponseEntity<UserLoginDto>(userLoginService.register(userLogin), HttpStatus.CREATED);
	}

}
