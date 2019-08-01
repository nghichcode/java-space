package com.ncvn.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncvn.a.entities.Contact;
import com.ncvn.a.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value={"/", "/contact-list"})
	public String listContact(Model model) {
		List<Contact> lc= contactService.findAll();
		for (Contact contact : lc) {System.out.println(contact.getName());}

//		model.addAttribute("listContact", contactService.findAll());
		return "contact-list";
	}

	@RequestMapping("/contact-save")
	public String insertContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact-save";
	}

	@RequestMapping("/contact-view/{id}")
	public String viewContact(@PathVariable int id, Model model) {
		System.out.println(id);
		Contact contact = contactService.findById(id);
		System.out.println(contact.getEmail());
		model.addAttribute("contact", contact);
		return "contact-view";
	}
	
	@RequestMapping("/contact-update/{id}")
	public String updateContact(@PathVariable int id, Model model) {
		Contact contact = contactService.findById(id);
		model.addAttribute("contact", contact);
		return "contact-update";
	}

	@RequestMapping("/saveContact")
	public String doSaveContact(@ModelAttribute("Contact") Contact contact, Model model) {
		contactService.save(contact);
		model.addAttribute("listContact", contactService.findAll());
		return "contact-list";
	}

	@RequestMapping("/updateContact")
	public String doUpdateContact(@ModelAttribute("Contact") Contact contact, Model model) {
		contactService.update(contact);
		model.addAttribute("listContact", contactService.findAll());
		return "contact-list";
	}
	
	@RequestMapping("/contactDelete/{id}")
	public String doDeleteContact(@PathVariable int id, Model model) {
		contactService.delete(id);
		model.addAttribute("listContact", contactService.findAll());
		return "contact-list";
	}
}
