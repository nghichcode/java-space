package com.nc.pbackup;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RoleDAO {
	private static final String QUERYUS = "select r from Role r";
	
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public void save(Role rol) {
    	if (findByName(rol.getName()) == null) {
    		System.out.println("Addd Role!!! "+rol.getName());
        	Session session = sessionFactory.openSession();
    		try {
    			session.beginTransaction();session.save(rol);session.getTransaction().commit();
    		} catch (RuntimeException e) {
    			session.getTransaction().rollback();e.printStackTrace();
    		} finally {session.close();}    		
		} else {System.out.println("Role exists!");}
	}

	public Role findById(int id) {
		Session session = sessionFactory.openSession();
		Role con = session.find(Role.class, id);
		session.close();
		return con;
	}
	public Role findByName(String name) {
		try {
			Session session = sessionFactory.openSession();
			Query<Role> query=session.createQuery(QUERYUS+" where r.name=:name");
			query.setParameter("name", name);
			Role u = query.getSingleResult();
			session.close();
			return u;			
		} catch (NoResultException e) {
			System.out.println("Not Found! RoleDAO");
		}
		return null;
	}

	public List<Role> showAll() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<Role> list = session.createQuery(QUERYUS).getResultList();
			session.getTransaction().commit();
			return list;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();e.printStackTrace();
		} finally {session.close();}
		return null;
	}

	public Boolean update(Role Role) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(Role);
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
			Role Role = session.load(Role.class, id);
			session.delete(Role);
			session.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {session.close();}
		return null;
	}
}