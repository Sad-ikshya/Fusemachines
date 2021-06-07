package com.fuse.bankManagementSystem.configuration;

import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class ApplicationConfig extends AbstractMongoClientConfiguration {
	@Override
	protected String getDatabaseName() {
		return "bankManagement";
	}

	public MongoClient mongoclient() {
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/bankManagement");
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();
		return MongoClients.create(mongoClientSettings);
	}
}
