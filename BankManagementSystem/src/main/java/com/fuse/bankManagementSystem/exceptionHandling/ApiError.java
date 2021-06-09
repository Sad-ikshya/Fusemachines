package com.fuse.bankManagementSystem.exceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMMM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String details;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ApiError(HttpStatus status) {
		this.status = status;
		this.message = "Request failed with" + status;
		getCurrentTimestamp();
	}

	public void getCurrentTimestamp() {
		this.timestamp = LocalDateTime.now();
	}

	public ApiError(HttpStatus status, Throwable ex) {
		this.status = status;
		getCurrentTimestamp();
		this.message = "Request failed with" + status;
		this.details = ex.getLocalizedMessage();
	}

	public ApiError(HttpStatus status, String message, Throwable ex) {
		this.status = status;
		getCurrentTimestamp();
		this.message = message;
		this.details = ex.getLocalizedMessage();
	}

	public ApiError(HttpStatus status, String message) {
		this.status = status;
		getCurrentTimestamp();
		this.details = message;
	}

}
