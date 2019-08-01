package com.nc.sample.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nc.model.Contact;
import com.nc.sample.service.ContactDAO;

@Controller
public class ContactController {
	private ContactDAO dao = new ContactDAO();
	
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	@ResponseBody
	public List<Contact> contact(Model model) {
		return dao.showAll();
	}
	@RequestMapping(value="/contact/{id}/update",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Boolean update(@PathVariable int id) {
		Contact contact=new Contact();
		contact.setId(id);
		contact.setName("Update");
		contact.setPhone("123123123");
		contact.setEmail("abc@cc.cc");
		return dao.update(contact);
	}

	@RequestMapping(value="/contact/{id}/find",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Contact findById(@PathVariable int id) {
		Contact c= (Contact)dao.findById(id);
		return c;
	}
	@RequestMapping(value="/contact/{email}/finde",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Contact findByEmail(@PathVariable String email) {
		Contact c= (Contact)dao.findByEmail(email);
		return c;
	}

	@RequestMapping(value="/contact/{id}/delete",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Boolean delete(@PathVariable int id) {
		return dao.delete(id);
	}
}
