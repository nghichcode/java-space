package com.nc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nc.domain.Contact;
import com.nc.service.ContactServiceInterface;

@Controller
public class ContactController {
	@Autowired
	private ContactServiceInterface contactService;
	
	@GetMapping("/contact")
	public String contact(Model model) {
		System.err.println("Contact!!!");
		model.addAttribute("contacts",contactService.findAll());
		return "list";
	}
	@GetMapping("/contact/create")
	public String create(Model model) {
		model.addAttribute("contact",new Contact());
		return "form";
	}
	@PostMapping("/contact/save")
	public String save(@Valid Contact contact, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "form";
		}
		contactService.save(contact);
		attributes.addFlashAttribute("success","Save Successfully!");
		return "redirect:/contact";
	}
	@GetMapping("/contact/{id}/edit")
	public String edit(@PathVariable int id,Model model) {
		model.addAttribute("contact",contactService.findOne(id));
		return "form";
	}
	@GetMapping("/contact/{id}/delete")
	public String delete(@PathVariable int id,RedirectAttributes attributes) {
		contactService.delete(id);
		attributes.addFlashAttribute("success","Delete Successfully!");
		return "redirect:/contact";
	}
	@GetMapping("/contact/search")
	public String search(@RequestParam("q")String q,Model model) {
		if (q.equals("")) {return "redirect:/contact";}
		System.err.println("Search!!!");
		if (q.contains("@")) {model.addAttribute("contacts",contactService.searchEmail(q));
		} else {model.addAttribute("contacts",contactService.search(q));}
		return "list";
	}
	
	@RequestMapping(value= {"/","/home"},method=RequestMethod.GET)
	public String home(Model m) {
		return "home";
	}
}
