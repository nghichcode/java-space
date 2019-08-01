package com.ncvn.a.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ncvn.a.entities.Contact;

@Repository(value = "contactDAO")
@Transactional(rollbackFor = Exception.class)
public class ContactDAO {

    @PersistenceContext
    private EntityManager entityManager;


	public void persist(final Contact Contact) {
		entityManager.persist(Contact);
	}


	public Contact findById(final int id) {
		System.out.println(Contact.class.toString());
		return entityManager.find(Contact.class, id);
	}

	public void delete(final Contact Contact) {
		entityManager.remove(Contact);
	}

	public List<Contact> findAll() {
		return entityManager.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
	}
}
