package com.waa.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.waa.data.entity.Team;
import com.waa.data.service.TeamService;

@RestController
@RequestMapping(value="/team",
		produces=MediaType.APPLICATION_JSON_VALUE,
		consumes=MediaType.APPLICATION_JSON_VALUE)
public class TeamResource {
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(method=RequestMethod.PUT)			
	public Team createTeam(@Valid @RequestBody Team team){
		return teamService.create(team);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			value="/{id}")
	public Team updateTeam(@RequestParam("id") String teamId, @Valid @RequestBody Team team){
		return teamService.update(team);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public Team deleteTeam(@RequestParam("id") String teamId, @Valid @RequestBody Team team){
		return teamService.update(team);
	}
}
