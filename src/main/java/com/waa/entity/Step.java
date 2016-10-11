package com.waa.entity;

import java.time.LocalDateTime;

import com.waa.common.DBEntity;

public class Step extends DBEntity{
	private Integer stepCount;
	
	private LocalDateTime startDateTime;
	
	private LocalDateTime endDateTime;
	
	public Integer getStepCount() {
		return stepCount;
	}

	public void setStepCount(Integer stepCount) {
		this.stepCount = stepCount;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
}
