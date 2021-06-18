package com.fuse.techBlog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuse.techBlog.entities.UserLoginEntity;

public interface UserLoginRepository extends MongoRepository<UserLoginEntity, String> {

}
