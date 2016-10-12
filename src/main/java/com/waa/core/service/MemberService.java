package com.waa.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waa.core.entity.Member;
import com.waa.core.entity.Team;
import com.waa.core.entity.dao.MemberRepository;

@Service
public class MemberService {
	@Autowired MemberRepository memberRepository;  
	
	public Member fetchById(String id){
		return memberRepository.findOne(id);
	}
	
	public Member create(Team team, Member member){
		member.assignIdAndCreatedDateAndUpdatedDate();
		member.setTeam(team);
		return memberRepository.save(member);
	}
	
	public Member update(Member member){
		member.setUpdatedDate();
		return memberRepository.save(member);
	}
	
	public Member delete(Member member){
		memberRepository.delete(member);
		return member;
	}
}
