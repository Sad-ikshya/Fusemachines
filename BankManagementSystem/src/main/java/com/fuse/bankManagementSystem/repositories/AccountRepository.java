package com.fuse.bankManagementSystem.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuse.bankManagementSystem.entities.AccountEntity;

public interface AccountRepository extends MongoRepository<AccountEntity, String> {
	public List<AccountEntity> getByUserId(String userId);

}
