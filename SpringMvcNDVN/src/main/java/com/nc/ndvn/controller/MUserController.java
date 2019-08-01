package com.nc.ndvn.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nc.model.MUser;
import com.nc.model.MUserLite;
import com.nc.ndvn.service.MUserDAO;

@Controller
public class MUserController {
	private MUserDAO mdao = new MUserDAO();
	
	@RequestMapping(value="/MUser/{id}/update",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Boolean update(@PathVariable int id) {
		MUser m=new MUser();
		return mdao.update(m);
	}
	
	@RequestMapping(value="/MUser/{name}/find",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object findByUserName(@PathVariable String name) {
		System.out.println("findByUserName: "+name);
		Object[] l = mdao.findByUserName(name);
		
		MUserLite mul=new MUserLite((long)l[0],(long)l[1],(Date)l[2],(long)l[3],(Date)l[4],(String)l[5],(String)l[6]);
		return (Object)mul;
	}
	@RequestMapping(value="/MUser/{id}/findid",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public MUser findById(@PathVariable long id) {
		System.out.println("Call me!");
		return (MUser) mdao.findById(id);
	}	
	@RequestMapping(value="/MUser/{name}/findlite",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public MUserLite findLite(@PathVariable String name) {
		System.out.println("findByUserName: "+name);
		MUserLite l = mdao.findLite(name);
		return (MUserLite)l;
	}

	@RequestMapping(value="/MUser/all",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<MUser> all() {
		return (List<MUser>) mdao.showAll();
	}

	@RequestMapping(value="/MUser/{id}/delete",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Boolean delete(@PathVariable int id) {
		return mdao.delete(id);
	}
}
