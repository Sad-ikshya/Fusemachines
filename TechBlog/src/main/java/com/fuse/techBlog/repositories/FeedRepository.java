package com.fuse.techBlog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuse.techBlog.entities.FeedEntity;

public interface FeedRepository extends MongoRepository<FeedEntity, String> {

}
