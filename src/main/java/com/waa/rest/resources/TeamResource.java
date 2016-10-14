package com.waa.rest.resources;

import java.util.ArrayList;
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
import com.waa.core.entity.Step;
import com.waa.core.entity.Team;
import com.waa.core.service.MemberService;
import com.waa.core.service.TeamService;
import com.waa.rest.entity.Location;

@RestController
@RequestMapping(value="/team",
		produces=MediaType.APPLICATION_JSON_VALUE,
		consumes=MediaType.APPLICATION_JSON_VALUE)
public class TeamResource {
	private static final Double START_LATITUDE = 42.3601;
	
	private static final Double START_LONGITUDE = 71.0589;
	
	private static final Double END_LATITUDE = 37.7749;
	
	private static final Double END_LONGITUDE = 122.4194;
	
	private static final Integer TOTAL_STEPS = 6000000;
	
	private static final String[] COLORS = {"BLACK","BLUE","CYAN","GRAY","GREEN","MAGENTA","ORANGE",
			"PINK","RED","WHITE","YELLOW"};
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(method=RequestMethod.GET,
			consumes=MediaType.ALL_VALUE)
	public List<Team> getAllTeams(){	
		return teamService.fetchAllTeams();
	}
	
	@RequestMapping(method=RequestMethod.GET,
			consumes=MediaType.ALL_VALUE,value="/locations")
	public List<Location> getAllTeamLocations(){	
		List<Team> teams = teamService.fetchAllTeams();
		List<Location> locations = new ArrayList<Location>();

		for (Team team : teams) {
			Location location = new Location();
			location.setTeamId(team.get_id());
			location.setTeamName(team.getName());
			location.setTeamColor(COLORS[teams.indexOf(team) % COLORS.length]);
			for (Member member : team.getTeamMembers()){
				for(Step step : member.getSteps()){
					location.addTotalStepCount(step.getStepCount());
				}
			}
			// Co-ordinate calculations			
			Double x = START_LATITUDE+(location.getTotalStepCount())*(END_LATITUDE - START_LATITUDE) / TOTAL_STEPS;
			Double y = START_LONGITUDE+(location.getTotalStepCount())*(END_LONGITUDE - START_LONGITUDE) / TOTAL_STEPS;
			location.setLatitude(x);
			location.setLongitude(y);
			locations.add(location);
		}
		return locations;
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
