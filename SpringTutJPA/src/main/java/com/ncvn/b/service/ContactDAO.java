package com.ncvn.b.service;

import com.ncvn.b.domain.Contact;

public interface ContactDAO {
//	Iterable<Contact> findAll();
//	List<Contact> search(String q);
//	List<Contact> searchEmail(String q);
	Contact findOne(int id);
//	void save(Contact contact);
//	void delete(int id);
}
