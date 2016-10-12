package com.waa.core.entity.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.waa.core.entity.Team;

public interface TeamRepository extends MongoRepository<Team,String>{

}
