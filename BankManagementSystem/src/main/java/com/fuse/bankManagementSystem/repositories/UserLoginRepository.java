package com.fuse.bankManagementSystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuse.bankManagementSystem.entities.UserLoginEntity;

public interface UserLoginRepository extends MongoRepository<UserLoginEntity, String> {
	UserLoginEntity findByUserName(String userName);
}
