package com.fuse.financeManagement.exceptionHandling;

import java.net.http.HttpHeaders;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	protected ResponseEntity<Object> messageNotReadable(HttpMessageNotReadableException ex) {
		String error = "Json format is invalid please check";

		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	}

	@ExceptionHandler(MissingRequestHeaderException.class)
	protected ResponseEntity<Object> missingRequestHeader(MissingRequestHeaderException ex) {
		String error = "Missing header please check";

		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	}

	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<Object> userNotFound(UserNotFoundException ex) {
		String error = "user is not found please check id";
		return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error, ex));
	}

	@ExceptionHandler(MethodNotAllowedException.class)
	protected ResponseEntity<Object> methodNotAllowed(MethodNotAllowedException ex) {
		String error = "Http Method not allowed please verify";
		return buildResponseEntity(new ApiError(HttpStatus.NOT_ACCEPTABLE, error, ex));
	}

	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<Object> handleInternalServerError(HttpStatus httpStatus) {
		String error = "Internal server error, Try again";

		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error));
	}
}
