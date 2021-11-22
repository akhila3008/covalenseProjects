package com.cov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@ResponseBody
	@RequestMapping(value="hello/{name}/{place}",method=RequestMethod.GET)
	public String sayHello(@PathVariable String name, @PathVariable String place ) {
		return "hello"+name+" how do you feel in "+place+"?";
	}
	
	@ResponseBody
	@RequestMapping(value="hello", method= RequestMethod.POST)
	public String newSayHello(@RequestParam String name, @RequestParam String place) {
		return "hello "+name+" this is bad"+place;
	}
	
	@ResponseBody
	@RequestMapping(value="hello", method= RequestMethod.DELETE)
	public String sayDelete() {
		return "inside DELETE method";
	}
	@ResponseBody
	@RequestMapping(value="hello", method= RequestMethod.PUT)
	public String sayPut() {
		return "inside PUT method";
	}
    
}
