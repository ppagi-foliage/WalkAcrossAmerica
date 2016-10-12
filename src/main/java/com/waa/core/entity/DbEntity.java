package com.waa.core.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;

public class DbEntity
{
	@Id
    private String _id;
    
    private LocalDateTime createdDate;
    
    private LocalDateTime updatedDate;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	public void setUpdatedDate(LocalDateTime... updatedDate) {
		if (updatedDate != null && updatedDate.length > 0)
			this.updatedDate = updatedDate[0];
		else
			this.updatedDate = LocalDateTime.now();
	}        	
	
	public void assignIdAndCreatedDateAndUpdatedDate(){
		this.set_id(UUID.randomUUID().toString());
		this.setCreatedDate(LocalDateTime.now());
		this.setUpdatedDate();
	}
}