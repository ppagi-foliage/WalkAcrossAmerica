package com.waa.core.service;

import java.time.LocalDateTime;
import java.util.UUID;

import com.waa.core.entity.User;

public class UserService {
	public User register(User user){
		user.set_id(UUID.randomUUID().toString());
		user.setCreatedDate(LocalDateTime.now());
		user.setUpdatedDate(LocalDateTime.now());
		return user;
	}
	
	public User update(User user){
		user.setUpdatedDate(LocalDateTime.now());
		return user;
	}
	
	public User delete(User user){
		return user;
	}
}
