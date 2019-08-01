package com.ncvn.c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncvn.c.domain.Contact;

@Service
@Transactional
public class EMContactService {
	@Autowired
	private EMContactDAO eMContactDAO;
	
	public List<Contact> findAll() {
		return eMContactDAO.findAll();
	}

	public Contact finById(final int id) {
		return eMContactDAO.finById(id);
	}
	
	public void save(final Contact c) {		
		eMContactDAO.save(c);
	}

	public void update(final Contact c) {
		eMContactDAO.update(c);
	}

	public void delete(final int id) {
		Contact cdb=eMContactDAO.finById(id);
		if (cdb!=null) {eMContactDAO.delete(cdb);}
	}
	
	
}
