package com.ncvn.b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncvn.b.domain.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDAO dao;

	public Contact findOne(int id) {
		Contact c=dao.findOne(id);
		if (c==null) {return null;}
		
		return c;
	}
}
