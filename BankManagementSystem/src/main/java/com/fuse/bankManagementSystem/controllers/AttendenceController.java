package com.fuse.bankManagementSystem.controllers;

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

import com.fuse.bankManagementSystem.dtos.AttendenceDto;
import com.fuse.bankManagementSystem.services.AttendenceService;

@RestController
@RequestMapping("/attendence")
public class AttendenceController {
	@Autowired
	private AttendenceService attendenceService;

	@GetMapping("/")
	public ResponseEntity<List<AttendenceDto>> getAllAttendence() {
		return new ResponseEntity<List<AttendenceDto>>(attendenceService.getAllAttendence(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<AttendenceDto> saveAttendence(@RequestBody AttendenceDto attendence) {
		return new ResponseEntity<AttendenceDto>(attendenceService.saveAttendence(attendence), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AttendenceDto> getAttendenceById(@PathVariable String id) {
		return new ResponseEntity<AttendenceDto>(attendenceService.getAttendenceById(id), HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AttendenceDto> updateAttendence(@PathVariable String id,
			@RequestBody AttendenceDto attendence) {
		return new ResponseEntity<AttendenceDto>(attendenceService.updateAttendence(id, attendence), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteAttendence(@PathVariable String id) {
		attendenceService.deleteAttendence(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("/getEmployeeById/{employeeId}")
	public ResponseEntity<List<AttendenceDto>> getAttendenceByEmployeeId(@PathVariable String employeeId) {
		return new ResponseEntity<List<AttendenceDto>>(attendenceService.getAttendenceByEmployeeId(employeeId),
				HttpStatus.OK);
	}

}
