package com.waa.rest.entity;

public class Location {
	private Double latitude;
	
	private Double longitude;
	
	private String teamId;
	
	private String teamName;
	
	private String teamColor;
	
	private Integer totalStepCount = 0;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamColor() {
		return teamColor;
	}

	public void setTeamColor(String teamColor) {
		this.teamColor = teamColor;
	}

	public Integer getTotalStepCount() {
		return totalStepCount;
	}

	public void addTotalStepCount(Integer totalStepCount) {
		this.totalStepCount += totalStepCount;
	}
}
