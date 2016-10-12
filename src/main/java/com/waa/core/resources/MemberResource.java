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
import com.waa.core.entity.Step;
import com.waa.core.service.MemberService;
import com.waa.core.service.StepService;

@RestController
@RequestMapping(value="/member",
produces=MediaType.APPLICATION_JSON_VALUE,
consumes=MediaType.APPLICATION_JSON_VALUE)
public class MemberResource {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private StepService stepService;
	
	@RequestMapping(method=RequestMethod.POST,
			value="/{id}")
	public Member updateMember(@RequestParam("id") String id, @Valid @RequestBody Member member){
		return memberService.update(member);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public Member deleteMember(@RequestParam("id") String id, @Valid @RequestBody Member member){
		return memberService.delete(member);
	}
	
	@RequestMapping(method=RequestMethod.GET,
			value="/{id}/steps")			
	public List<Step> getSteps(@PathVariable("id") String id){
		Member member = memberService.fetchById(id);
		return member.getSteps();
	}

	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}/step")			
	public Step addStep(@PathVariable("id") String id, @Valid @RequestBody Step step){
		Member member = memberService.fetchById(id);
		return stepService.create(member, step);
	}
}
