package com.fuse.techBlog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuse.techBlog.entities.ReactionEntity;

public interface ReactionRepository extends MongoRepository<ReactionEntity, String> {

}
