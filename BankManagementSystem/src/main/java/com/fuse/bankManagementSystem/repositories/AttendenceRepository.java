package com.fuse.bankManagementSystem.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuse.bankManagementSystem.entities.AttendenceEntity;

public interface AttendenceRepository extends MongoRepository<AttendenceEntity, String> {
	public List<AttendenceEntity> getByEmployeeId(String employeeId);

}
