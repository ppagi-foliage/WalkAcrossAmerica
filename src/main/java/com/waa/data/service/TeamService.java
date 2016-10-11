package com.waa.data.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.waa.data.entity.Team;

@Service
public class TeamService {
	
	public Team create(Team team){
		team.set_id(UUID.randomUUID().toString());
		team.setCreatedDate(LocalDateTime.now());
		team.setUpdatedDate(LocalDateTime.now());
		return team;
	}
	
	public Team update(Team team){
		team.setUpdatedDate(LocalDateTime.now());
		return team;
	}
}
