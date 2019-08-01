package com.nc.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiController {
	@RequestMapping("/")
	public String index() {return "index";}
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {return "hello";}

	@RequestMapping(value="/hi",method=RequestMethod.GET)
	@ResponseBody
	public String hi() {return "hello";}

//	@RequestMapping(value="/tk",method=RequestMethod.GET,produces="application/json")
//	public String token() {
//		UserRest ur=new UserRest();
//		ur.setUserId("12DS");
//		ur.setLastName("Cya");
//		ur.setFirstName("Tin");
//		ur.setEmail("abc@cc.cc");
//		
//		return "token";
//	}

}
