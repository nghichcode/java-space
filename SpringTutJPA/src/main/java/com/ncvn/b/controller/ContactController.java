package com.ncvn.b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncvn.b.domain.Contact;
import com.ncvn.b.service.EMContactService;

@Controller
public class ContactController {

	@Autowired
	private EMContactService service;

	@RequestMapping("/bi")
	public String index() {return "home";}
	@RequestMapping({"/bhome"})
	public String contact() {
		List<Contact> lc= service.findAll();
		for (Contact contact : lc) {System.out.println(contact.getName());}
		System.out.println("================");
		Contact c= service.finById(6);
		System.out.println(c.getName());
		
		Contact ct=new Contact(0, "Minion", "cc@cc.cc", "2121212121212");
		try {
			service.save(ct);
		} catch (NullPointerException e) {System.out.println(e.getMessage());}
		
		return "home";
	}
	@RequestMapping({"/"})
	public String admin() {return "home-admin";}

}
