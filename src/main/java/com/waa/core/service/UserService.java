package com.waa.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waa.core.entity.User;
import com.waa.core.entity.dao.UserRepository;

@Service
public class UserService {
	@Autowired UserRepository userRepository;
	public User register(User user){
		user.assignIdAndCreatedDateAndUpdatedDate();
		userRepository.save(user);
		return user;
	}
	
	public User update(User user){
		user.setUpdatedDate();
		userRepository.save(user);
		return user;
	}
	
	public User delete(User user){
		userRepository.delete(user);
		return user;
	}
}
