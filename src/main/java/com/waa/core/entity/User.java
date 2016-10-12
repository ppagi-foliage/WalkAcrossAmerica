package com.waa.core.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class User extends Person{
	@NotNull
    private String username;
    
	@NotNull
    private String password;
    
    private LocalDateTime lastLoginDateTime;
    
    private LocalDateTime lastFailDateTime;
    
    private Integer totalFailCount;
    
    @NotNull
    private Boolean isActive;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public void setLastLoginDateTime(LocalDateTime lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	public LocalDateTime getLastFailDateTime() {
		return lastFailDateTime;
	}

	public void setLastFailDateTime(LocalDateTime lastFailDateTime) {
		this.lastFailDateTime = lastFailDateTime;
	}
	
	public Integer getTotalFailCount() {
		return totalFailCount;
	}

	public void setTotalFailCount(Integer totalFailCount) {
		this.totalFailCount = totalFailCount;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}	
}
