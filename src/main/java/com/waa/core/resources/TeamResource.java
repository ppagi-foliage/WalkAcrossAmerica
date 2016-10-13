package com.waa.core.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.waa.core.entity.Member;
import com.waa.core.entity.Team;
import com.waa.core.service.MemberService;
import com.waa.core.service.TeamService;

@RestController
@RequestMapping(value="/team",
		produces=MediaType.APPLICATION_JSON_VALUE,
		consumes=MediaType.APPLICATION_JSON_VALUE)
public class TeamResource {
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(method=RequestMethod.GET,
			consumes=MediaType.ALL_VALUE)
	public List<Team> getAllTeams(){	
		return teamService.fetchAllTeams();
	}
	
	@RequestMapping(method=RequestMethod.PUT)			
	public Team createTeam(@Valid @RequestBody Team team){
		return teamService.create(team);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			value="/{id}")
	public Team updateTeam(@RequestParam("id") String id, @Valid @RequestBody Team team){
		return teamService.update(team);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public Team deleteTeam(@RequestParam("id") String id, @Valid @RequestBody Team team){
		return teamService.delete(team);
	}
	
	@RequestMapping(method=RequestMethod.GET,
			value="/{id}/members",
			consumes=MediaType.ALL_VALUE)			
	public List<Member> getMembers(@PathVariable("id") String id){
		Team team = teamService.fetchById(id);
		return team.getTeamMembers();
	}

	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}/member")			
	public Member addMember(@PathVariable("id") String id, @Valid @RequestBody Member member){
		Team team = teamService.fetchById(id);
		return memberService.create(team, member);
	}
}
