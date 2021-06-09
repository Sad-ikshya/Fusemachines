package com.fuse.bankManagementSystem.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response<T> {
	public ResponseEntity<Map<String, Object>> getPageResponseEntity(Page<T> pageData, HttpStatus httpStatus) {
		Map<String, Object> response = new HashMap<>();
		response.put("data", pageData.getContent());
		response.put("currentPage", pageData.getNumber());
		response.put("totalItems", pageData.getTotalElements());
		response.put("totalPages", pageData.getTotalPages());
		return new ResponseEntity<>(response, httpStatus);
	}

}
