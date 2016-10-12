package com.waa.core.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class Member extends Person{
	enum TeamMemberRole{TEAM_LEAD,TEAM_MEMBER};
	@DBRef
	@JsonIgnore
	private Team team;
	
	@NotNull
	private Boolean isActive;
	
	@NotNull
	private TeamMemberRole role;
	
	@DBRef
	private List<Step> steps = new ArrayList<Step>();

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public TeamMemberRole getRole() {
		return role;
	}

	public void setRole(TeamMemberRole role) {
		this.role = role;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}	
}
