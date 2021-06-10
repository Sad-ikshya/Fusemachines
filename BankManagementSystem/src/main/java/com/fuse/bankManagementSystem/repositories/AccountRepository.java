package com.fuse.bankManagementSystem.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fuse.bankManagementSystem.entities.AccounType;
import com.fuse.bankManagementSystem.entities.AccountEntity;

public interface AccountRepository extends MongoRepository<AccountEntity, String> {
	public List<AccountEntity> getByUserId(String userId);

	@Query("{'accountType': ?0}")
	public Page<AccountEntity> findByAccountType(AccounType accountType, Pageable pageRequest);

}
