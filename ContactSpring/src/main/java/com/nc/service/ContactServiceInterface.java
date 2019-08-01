package com.nc.service;

import java.util.List;

import com.nc.domain.Contact;

public interface ContactServiceInterface {
	Iterable<Contact> findAll();
	List<Contact> search(String q);
	List<Contact> searchEmail(String q);
	Contact findOne(int id);
	void save(Contact contact);
	void delete(int id);
}
