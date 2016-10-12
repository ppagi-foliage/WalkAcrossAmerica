package com.waa.core.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Team extends DbEntity{
	@NotNull
	private String name;
	
	@NotNull
	private String description;
	
	@DBRef
	private List<Member> teamMembers = new ArrayList<Member>();
	
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
