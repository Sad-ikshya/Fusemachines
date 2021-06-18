package com.fuse.techBlog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class ApplicationConfig {
	@Bean
	public static MongoClient mongo() {
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/techBlog");
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();
		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public static MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "techBlog");
	}
}
