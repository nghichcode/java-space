package com.nc.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nc.model.Contact;
import com.nc.sample.service.ContactDAO;

@Controller
public class RestHiController {

	@RequestMapping(value="oauth/token",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Contact token() {
		Contact contact=new Contact();
		contact.setName("Tin CC Cya");
		contact.setPhone("123123123");
		contact.setEmail("abc@cc.cc");
		
		ContactDAO dao = new ContactDAO();
		dao.save(contact);
		
		return contact;
	}
	
}
