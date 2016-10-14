package com.waa.rest.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello")
public class HelloWorldResource {

	@RequestMapping(method=RequestMethod.GET)
	public String get(){
		return "HelloWorld !!";
	}
}
