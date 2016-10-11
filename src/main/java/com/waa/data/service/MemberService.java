package com.waa.data.service;

import java.time.LocalDateTime;

import com.waa.data.entity.Member;
import com.waa.data.entity.Team;

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
