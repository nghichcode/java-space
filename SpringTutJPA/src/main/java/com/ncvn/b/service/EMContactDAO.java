package com.ncvn.b.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ncvn.b.domain.Contact;

@Repository(value="eMContactDAO")
@Transactional(rollbackFor = Exception.class)
public class EMContactDAO {
	@PersistenceContext
	private EntityManager manager;
	
	public void persist(final Contact c) {
		manager.persist(c);
	}
	
	public Contact finById(final int id) {
		return manager.find(Contact.class, id);
	}
	
	public void delete(final Contact c) {
		manager.remove(c);
	}
	
	public List<Contact> findAll() {
		return manager.createQuery("from Contact", Contact.class).getResultList();
	}
}
