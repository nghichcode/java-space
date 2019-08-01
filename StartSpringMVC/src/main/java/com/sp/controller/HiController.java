package com.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiController {
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("pr", com.nccm.PowUtils.sq(99) );
		return "index";
	}
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {return "hello";}
	@RequestMapping("/hi")
	@ResponseBody
	public String hi() {return "index";}

}
