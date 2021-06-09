package com.fuse.bankManagementSystem.services;

import java.util.List;

import com.fuse.bankManagementSystem.dtos.AttendenceDto;

public interface AttendenceService {
	public List<AttendenceDto> getAllAttendence();

	public AttendenceDto saveAttendence(AttendenceDto attendence);

	public AttendenceDto getAttendenceById(String id);

	public AttendenceDto updateAttendence(String id, AttendenceDto attendence);

	public void deleteAttendence(String id);

	public List<AttendenceDto> getAttendenceByEmployeeId(String employeeId);

}
