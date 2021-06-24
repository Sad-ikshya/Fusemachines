package com.fuse.oauthPractice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@GetMapping("/")
public String helloWorld() {
	return "Hello World";
}
	@GetMapping("/restricted")
	public String restricted() {
		return "to see this text you need to be logged in!";
	}
	
	@GetMapping("/login")
	public String login() {
		return "to see this text you need to be logged in!";
	}
}
