package com.ncvn.c.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncvn.c.domain.Contact;
import com.ncvn.c.service.EMContactService;

@RestController
public class ContactController {
	private class AMap {
		@SuppressWarnings("unused")
		public String key;
		@SuppressWarnings("unused")
		public String val;
		public AMap(String key, String val) {this.key = key;this.val = val;}
	}

	@Autowired
	private EMContactService eMContactService;

	@RequestMapping({"/"})
	public String admin() {return "home";}

	@RequestMapping({"/c/users"})
	public ResponseEntity<List<Contact>> getAllUser() {
		List<Contact> lc= eMContactService.findAll();
		for (Contact contact : lc) {System.out.println(contact.getName()+":"+contact.getEmail());}
		return new ResponseEntity<List<Contact>>(lc, HttpStatus.OK);
	}
	@RequestMapping({"/c/users/{id}"})
	public ResponseEntity<Object> getUserById(@PathVariable int id) {
		Contact c= eMContactService.finById(id);
		if (c!=null) {return new ResponseEntity<Object>(c, HttpStatus.OK);}
		return new ResponseEntity<Object>("Not Found", HttpStatus.OK);
	}
	@RequestMapping(value = {"/c/users/save"}, method=RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody Contact c) {
		Contact ct= eMContactService.finById(c.getId());
		if (ct!=null) {return new ResponseEntity<String>("Exists!", HttpStatus.OK);}
		eMContactService.save(c);
		return new ResponseEntity<String>("Created", HttpStatus.CREATED);
	}
	@RequestMapping(value = {"/c/users/update"}, method=RequestMethod.PUT)
	public ResponseEntity<AMap> updateUser(@RequestBody Contact c) {
		Contact ct= eMContactService.finById(c.getId());
		if (ct==null) {return new ResponseEntity<AMap>(new AMap("status", "Not Found!"), HttpStatus.NO_CONTENT);}
		eMContactService.update(c);
		return new ResponseEntity<AMap>(new AMap("status", "Updated!"), HttpStatus.OK);
	}
	@RequestMapping(value = {"/c/users/delete/{id}"}, method=RequestMethod.POST)
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		Contact ct= eMContactService.finById(id);
		if (ct==null) {return new ResponseEntity<String>("Not Found!", HttpStatus.NO_CONTENT);}
		eMContactService.delete(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.CREATED);
	}

}
