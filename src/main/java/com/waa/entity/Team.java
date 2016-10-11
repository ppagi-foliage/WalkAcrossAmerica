package com.waa.entity;

import java.util.List;

import com.waa.common.DBEntity;

public class Team extends DBEntity{
	private String name;
	
	private String description;
	
	private List<Member> teamMembers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Member> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<Member> teamMembers) {
		this.teamMembers = teamMembers;
	}		
}
