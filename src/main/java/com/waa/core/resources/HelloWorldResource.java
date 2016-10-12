package com.waa.core.resources;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello",
produces=MediaType.APPLICATION_JSON_VALUE,
consumes=MediaType.APPLICATION_JSON_VALUE)
public class HelloWorldResource {

	@RequestMapping(method=RequestMethod.GET,path="/")
	public String get(){
		return "HelloWorld !!";
	}
}
