package com.fuse.oauthClient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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
	public String login(@RequestParam(name="username", required=false, defaultValue="sadik") String name,@RequestParam(name="password", required=false, defaultValue="password") String password) {
		return "login";
	}
}