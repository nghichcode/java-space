package com.ncvn.b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncvn.b.domain.Contact;

@Service
@Transactional
public class EMContactService {
	@Autowired
	private EMContactDAO eMContactDAO;
	
	public Contact finById(final int id) {
		return eMContactDAO.finById(id);
	}
	public List<Contact> findAll() {
		return eMContactDAO.findAll();
	}
	
	public void save(final Contact c) {
		eMContactDAO.persist(c);
	}
	public void update(final Contact c) {
		Contact cDB=eMContactDAO.finById(c.getId());
		cDB.setEmail(c.getEmail());
		cDB.setName(c.getName());
		cDB.setPhone(c.getPhone());
		
		eMContactDAO.persist(cDB);
	}
	public void delete(final int id) {
		Contact cdb=eMContactDAO.finById(id);
		if (cdb!=null) {eMContactDAO.delete(cdb);}
	}

}
