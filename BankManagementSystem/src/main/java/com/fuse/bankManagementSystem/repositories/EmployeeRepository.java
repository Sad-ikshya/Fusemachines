package com.fuse.bankManagementSystem.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fuse.bankManagementSystem.entities.EmployeeEntity;
import com.fuse.bankManagementSystem.entities.Post;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {
	@Query(value = "{post: ?0}")
	public Page<EmployeeEntity> findByPost(Post post, Pageable pageable);
}
