package com.waa.data.service;

import java.time.LocalDateTime;
import java.util.UUID;

import com.waa.data.entity.Member;
import com.waa.data.entity.Step;

public class StepService {
	public Step fetchById(String id){
		return null;
	}
	
	public Step create(Member member, Step step){
		step.set_id(UUID.randomUUID().toString());
		step.setCreatedDate(LocalDateTime.now());
		step.setUpdatedDate(LocalDateTime.now());
		return step;
	}
	
	public Step update(Step step){
		step.setUpdatedDate(LocalDateTime.now());
		return step;
	}
	
	public Step delete(Step step){
		return step;
	}
}
