package com.fuse.bankManagementSystem.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fuse.bankManagementSystem.entities.TransactionEntity;

public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {

	public List<TransactionEntity> getByToAccountId(String accountId);

	@Query("{'ammount': {$gt: ?0, $lt: ?1}}")
	public Page<TransactionEntity> findByAmmount(double ammountGT, double ammountLT, Pageable pageable);

}
