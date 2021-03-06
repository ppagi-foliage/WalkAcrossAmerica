package com.waa.rest.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${map.start.latitude}")
	private Double startLatitude;
	
	@Value("${map.start.longitude}")
	private Double startLongitude;
	
	@Value("${map.end.latitude}")
	private Double endLatitude;
	
	@Value("${map.end.longitude}")
	private Double endLongitude;
	
	@Value("${map.steps.total}")
	private Integer totalSteps;
	
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
			Double x = startLatitude+(location.getTotalStepCount())*(endLatitude - startLatitude) / totalSteps;
			Double y = startLongitude+(location.getTotalStepCount())*(endLongitude - startLongitude) / totalSteps;
			location.setLatitude(x);
			location.setLongitude(y);
			locations.add(location);
		}
		return locations;
	}
	
	@RequestMapping(method=RequestMethod.GET,
			consumes=MediaType.ALL_VALUE,value="/tracks")
	public List<Location> getTrackLocations(){	
		List<Location> locations = new ArrayList<Location>();
		int stepSize = 100000;
		int totalTrackCount = totalSteps/stepSize;
		
		for(int i=0;i<totalTrackCount;i++){
			Location location = new Location();
			Double x = startLatitude+( i * stepSize)*(endLatitude - startLatitude) / totalSteps;
			Double y = startLongitude+(i * stepSize)*(endLongitude - startLongitude) / totalSteps;
			location.setTeamId(UUID.randomUUID().toString());
			location.setTeamName("Tracker Path "+i);
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
