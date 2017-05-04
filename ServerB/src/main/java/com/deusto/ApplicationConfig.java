package com.deusto;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories
class ApplicationConfig extends AbstractMongoConfiguration {

  @Override
  protected String getDatabaseName() {
    return "bookit_db";
  }

  @Override
  protected String getMappingBasePackage() {
    return "com.deusto.respositories";
  }
  
	@Override
	public MongoClient mongoClient() {
		return new MongoClient();
	}
}
