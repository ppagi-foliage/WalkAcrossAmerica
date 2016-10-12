package com.waa.core.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.waa.core.entity.User;
import com.waa.core.service.UserService;

@RestController
@RequestMapping(value="/user",
		produces=MediaType.APPLICATION_JSON_VALUE,
		consumes=MediaType.APPLICATION_JSON_VALUE)
public class UserResource {
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.PUT)			
	public User createUser(@Valid @RequestBody User user){
		return userService.register(user);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			value="/{id}")
	public User updateTeam(@RequestParam("id") String id, @Valid @RequestBody User user){
		return userService.update(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public User deleteTeam(@RequestParam("id") String id, @Valid @RequestBody User user){
		return userService.delete(user);
	}
}
