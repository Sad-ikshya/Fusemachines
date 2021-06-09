package com.fuse.bankManagementSystem.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fuse.bankManagementSystem.entities.Gender;
import com.fuse.bankManagementSystem.entities.UserEntity;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, String> {
	@Query("{'gender':?0}")
	public Page<UserEntity> findByGender(Gender gender, Pageable pageRequest);
}
