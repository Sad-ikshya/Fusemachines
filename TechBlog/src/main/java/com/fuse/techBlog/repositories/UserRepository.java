package com.fuse.techBlog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuse.techBlog.entities.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
	UserEntity findByEmail(String email);
}
