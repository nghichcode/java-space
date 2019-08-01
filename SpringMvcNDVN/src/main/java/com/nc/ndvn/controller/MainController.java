package com.nc.ndvn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {return "hello";}
	@RequestMapping("/home")
	public String home() {return "home";}
		@RequestMapping("/403")
    public String accessDenied() {return "403";}
	
}
