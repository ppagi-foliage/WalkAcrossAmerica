package com.waa.core.entity.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.waa.core.entity.User;

public interface UserRepository extends MongoRepository<User,String>{
	
}
