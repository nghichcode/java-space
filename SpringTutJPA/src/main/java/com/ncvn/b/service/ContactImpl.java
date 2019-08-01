package com.ncvn.b.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ncvn.b.domain.Contact;
@Repository
public class ContactImpl implements ContactDAO {
	@PersistenceContext
	private EntityManager em;

	public Contact findOne(int id) {
		return (Contact)em.find(Contact.class, id);
	}
}
