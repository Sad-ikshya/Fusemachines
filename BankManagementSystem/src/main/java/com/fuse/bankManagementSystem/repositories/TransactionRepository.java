package com.fuse.bankManagementSystem.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuse.bankManagementSystem.entities.TransactionEntity;

public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {

	public List<TransactionEntity> getByToAccountId(String accountId);

}
