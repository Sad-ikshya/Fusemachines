package com.fuse.bankManagementSystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuse.bankManagementSystem.entities.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {

}
