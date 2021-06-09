package com.fuse.bankManagementSystem.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "user not found")
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public String getlocalizedMessage() {
		return "User not found on database";
	}
}
