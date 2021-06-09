package com.fuse.bankManagementSystem.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuse.bankManagementSystem.dtos.AttendenceDto;
import com.fuse.bankManagementSystem.dtos.EmployeeDto;
import com.fuse.bankManagementSystem.entities.AttendenceEntity;
import com.fuse.bankManagementSystem.entities.EmployeeEntity;
import com.fuse.bankManagementSystem.repositories.AttendenceRepository;
import com.fuse.bankManagementSystem.services.AttendenceService;

@Service
public class AttendenceServiceImplementation implements AttendenceService {
	@Autowired
	AttendenceRepository attendenceRepository;

	@Override
	public List<AttendenceDto> getAllAttendence() {
		List<AttendenceEntity> attendence = attendenceRepository.findAll();
		List<AttendenceDto> attendenceDtoList = new ArrayList<>();
		for (AttendenceEntity a : attendence) {
			EmployeeDto employee = EmployeeDto.builder().id(a.employee.getId()).build();
			AttendenceDto attendenceDto = AttendenceDto.builder().id(a.getId()).employee(employee).date(a.getDate())
					.isPresent(a.isPresent()).build();

			attendenceDtoList.add(attendenceDto);
		}
		return attendenceDtoList;

	}

	@Override
	public AttendenceDto saveAttendence(AttendenceDto attendence) {
		EmployeeEntity employee = EmployeeEntity.builder().id(attendence.employee.getId()).build();
		AttendenceEntity attendenceEntity = AttendenceEntity.builder().id(attendence.getId()).employee(employee)
				.date(attendence.getDate()).isPresent(attendence.isPresent()).build();
		attendenceEntity = attendenceRepository.save(attendenceEntity);
		attendence.setId(attendenceEntity.getId());
		return attendence;
	}

	@Override
	public AttendenceDto getAttendenceById(String id) {
		AttendenceEntity attendence = attendenceRepository.findById(id).get();
		EmployeeDto employee = EmployeeDto.builder().id(attendence.employee.getId()).build();
		return AttendenceDto.builder().id(attendence.getId()).employee(employee).date(attendence.getDate())
				.isPresent(attendence.isPresent()).build();
	}

	@Override
	public AttendenceDto updateAttendence(String id, AttendenceDto attendence) {
		EmployeeEntity employee = EmployeeEntity.builder().id(attendence.employee.getId()).build();
		AttendenceEntity attendenceEntity = AttendenceEntity.builder().id(id).employee(employee)
				.date(attendence.getDate()).isPresent(attendence.isPresent()).build();
		attendenceEntity = attendenceRepository.save(attendenceEntity);
		attendence.setId(attendenceEntity.getId());
		return attendence;
	}

	@Override
	public void deleteAttendence(String id) {
		attendenceRepository.deleteById(id);
	}

	@Override
	public List<AttendenceDto> getAttendenceByEmployeeId(String employeeId) {
		List<AttendenceEntity> attendence = attendenceRepository.getByEmployeeId(employeeId);
		List<AttendenceDto> attendenceDtoList = new ArrayList<>();
		for (AttendenceEntity atten : attendence) {
			EmployeeDto employee = EmployeeDto.builder().id(atten.getEmployee().getId()).build();
			AttendenceDto attendenceDto = AttendenceDto.builder().id(atten.getId()).employee(employee)
					.date(atten.getDate()).isPresent(atten.isPresent()).build();

			attendenceDtoList.add(attendenceDto);
		}
		return attendenceDtoList;
	}

}
