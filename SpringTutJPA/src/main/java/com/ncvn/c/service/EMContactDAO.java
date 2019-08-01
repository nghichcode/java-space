package com.ncvn.c.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ncvn.c.domain.Contact;

@Repository(value="eMContactDAO")
@Transactional(rollbackFor = Exception.class)
public class EMContactDAO {
	@Autowired
	private SessionFactory factory;
	
	public List<Contact> findAll() {
		Session s=this.factory.getCurrentSession();
		return s.createQuery("from Contact", Contact.class).getResultList();
	}

	public Contact finById(final int id) {
		Session s=this.factory.getCurrentSession();
		return s.find(Contact.class, id);
	}
	
	public void save(final Contact c) {
		Session s=this.factory.getCurrentSession();
		s.save(c);
	}
	public void update(final Contact c) {
		Session s=this.factory.getCurrentSession();
		s.update(c);
	}
	public void delete(final Contact c) {
		Session s=this.factory.getCurrentSession();
		s.remove(c);
	}
	
}
