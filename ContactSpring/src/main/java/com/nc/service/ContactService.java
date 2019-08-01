package com.nc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nc.domain.Contact;
import com.nc.repository.ContactRepository;
@Service
public class ContactService implements ContactServiceInterface {
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public Iterable<Contact> findAll() {
		return contactRepository.findAll();
	}

	@Override
	public List<Contact> search(String q) {
		return contactRepository.findByNameContaining(q);
	}
	@Override
	public List<Contact> searchEmail(String q) {
		return contactRepository.findByEmailContaining(q);
	}

	
	@Override
	public Contact findOne(int id) {
		return contactRepository.findOne(id);
	}

	@Override
	public void save(Contact contact) {
		contactRepository.save(contact);
	}

	@Override
	public void delete(int id) {
		contactRepository.delete(id);
	}
}
