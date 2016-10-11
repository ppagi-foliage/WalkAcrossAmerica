package com.waa.data.entity;

import java.time.LocalDateTime;

public class Step extends DbEntity{
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
