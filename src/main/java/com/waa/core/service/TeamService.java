package com.waa.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waa.core.entity.Team;
import com.waa.core.entity.dao.TeamRepository;

@Service
public class TeamService {
	@Autowired TeamRepository teamRepository;
	
	public Team fetchById(String id){
		return teamRepository.findOne(id);
	}
	
	public Team create(Team team){
		team.assignIdAndCreatedDateAndUpdatedDate();
		teamRepository.save(team);
		return team;
	}
	
	public Team update(Team team){
		team.setUpdatedDate();
		teamRepository.save(team);
		return team;
	}
	
	public Team delete(Team team){
		teamRepository.delete(team);
		return team;
	}
}
