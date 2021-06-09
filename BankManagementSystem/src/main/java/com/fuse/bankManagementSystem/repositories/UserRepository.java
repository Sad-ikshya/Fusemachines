package com.fuse.bankManagementSystem.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fuse.bankManagementSystem.entities.Gender;
import com.fuse.bankManagementSystem.entities.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
	@Query("{'gender':?0}")
	public Page<UserEntity> findByGender(Gender gender, Pageable pageRequest);
}
