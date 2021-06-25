package com.fuse.oauth2Practice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuse.oauth2Practice.entities.User;

public interface UserRepository extends MongoRepository<User, String>{
	User findByUsername(String username);

}
