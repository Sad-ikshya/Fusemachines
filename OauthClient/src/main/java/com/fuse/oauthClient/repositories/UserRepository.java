package com.fuse.oauthClient.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuse.oauthClient.entities.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String>{
	public UserEntity getByEmail(String email);
}
