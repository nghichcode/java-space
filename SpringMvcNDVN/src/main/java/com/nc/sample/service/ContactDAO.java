package com.nc.sample.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nc.model.Contact;

public class ContactDAO {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public void save(Contact contact) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(contact);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {session.close();}
	}

	public Contact findById(int id) {
		Session session = sessionFactory.openSession();
		Contact con = session.find(Contact.class, id);
		session.close();
		return con;
	}
	public Contact findByEmail(String email) {
		Session session = sessionFactory.openSession();
		Contact con = session.find(Contact.class, email);
		session.close();
		return con;
	}

	public List<Contact> showAll() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<Contact> list = session.createQuery("SELECT c FROM Contact c").getResultList();
			session.getTransaction().commit();
			return list;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();e.printStackTrace();
		} finally {session.close();}
		return null;
	}

	public Boolean update(Contact con) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(con);
			session.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {session.close();}
		return null;
	}

	public Boolean delete(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Contact con = session.load(Contact.class, id);
			session.delete(con);
			session.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {session.close();}
		return null;
	}
}