package com.waa.core.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.waa.core.entity.Member;
import com.waa.core.entity.Team;

@Service
public class MemberService {
	public Member fetchById(String id){
		return null;
	}
	
	public Member create(Team team, Member member){		
		return member;
	}
	
	public Member update(Member member){
		member.setUpdatedDate(LocalDateTime.now());
		return member;
	}
	
	public Member delete(Member member){
		return member;
	}
}
