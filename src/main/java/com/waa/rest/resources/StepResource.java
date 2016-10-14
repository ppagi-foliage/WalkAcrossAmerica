package com.waa.rest.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.waa.core.entity.Step;
import com.waa.core.service.StepService;


@RestController
@RequestMapping(value="/step",
produces=MediaType.APPLICATION_JSON_VALUE,
consumes=MediaType.APPLICATION_JSON_VALUE)
public class StepResource {
	@Autowired
	private StepService stepService;
	
	@RequestMapping(method=RequestMethod.POST,
			value="/{id}")
	public Step updateStep(@RequestParam("id") String id, @Valid @RequestBody Step step){
		return stepService.update(step);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public Step deleteStep(@RequestParam("id") String id, @Valid @RequestBody Step step){
		return stepService.delete(step);
	}
}