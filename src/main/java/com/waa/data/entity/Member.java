package com.waa.data.entity;

import java.util.List;

public class Member extends Person{
	enum TeamMemberRole{TEAM_LEAD,TEAM_MEMBER};
	private Team team;
	
	private Boolean isActive;
	
	private TeamMemberRole role;
	
	private List<Step> steps;

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
