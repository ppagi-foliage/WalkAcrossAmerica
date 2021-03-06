package com.waa.application;

import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

//@Configuration
//@EnableMongoRepositories("com.waa.core.entity.dao")
public class MongoDbConfiguration extends AbstractMongoConfiguration{

	@Override
	protected String getDatabaseName() {
		return "WalkAcrossAmerica";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost", 27017);
	}
}
