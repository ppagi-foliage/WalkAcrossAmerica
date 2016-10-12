package com.waa.core.entity.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.waa.core.entity.Member;

public interface MemberRepository extends MongoRepository<Member,String> {

}
