package com.waa.core.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

public class Team extends DbEntity{
	@NotNull
	private String name;
	
	@NotNull
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
