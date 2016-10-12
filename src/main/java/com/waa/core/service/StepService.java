package com.waa.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waa.core.entity.Member;
import com.waa.core.entity.Step;
import com.waa.core.entity.dao.MemberRepository;
import com.waa.core.entity.dao.StepRepository;

@Service
public class StepService {
	@Autowired StepRepository stepRepository;
	
	@Autowired MemberRepository memberRepository;  
	
	public Step fetchById(String id){
		return stepRepository.findOne(id);
	}
	
	public Step create(Member member, Step step){
		step.assignIdAndCreatedDateAndUpdatedDate();
		member.getSteps().add(step);
		stepRepository.save(step);
		memberRepository.save(member);
		return step;
	}
	
	public Step update(Step step){
		step.setUpdatedDate();
		stepRepository.save(step);
		return step;
	}
	
	public Step delete(Step step){
		step.setUpdatedDate();
		return stepRepository.save(step);
	}
}
