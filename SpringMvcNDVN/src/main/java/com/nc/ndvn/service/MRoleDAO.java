package com.nc.ndvn.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nc.model.MRole;

public class MRoleDAO {
	private static final String QUERYUS = "select r from MRole r";
	
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public void save(MRole rol) {
    	if (findByName(rol.getRoleName()) == null) {
    		System.out.println("Addd MRole!!! "+rol.getRoleName());
        	Session session = sessionFactory.openSession();
    		try {
    			session.beginTransaction();session.save(rol);session.getTransaction().commit();
    		} catch (RuntimeException e) {
    			session.getTransaction().rollback();e.printStackTrace();
    		} finally {session.close();}    		
		} else {System.out.println("MRole exists!");}
	}

	public MRole findById(long id) {
		Session session = sessionFactory.openSession();
		MRole con = session.find(MRole.class, id);
		con.setMUserRoleses(null);
		System.out.println(con.toString());
		session.close();
		return con;
	}
	public MRole findByName(String name) {
		try {
			Session session = sessionFactory.openSession();
			Query<MRole> query=session.createQuery(QUERYUS+" where r.name=:name");
			query.setParameter("name", name);
			MRole u = query.getSingleResult();
			session.close();
			return u;			
		} catch (NoResultException e) {System.out.println("Not Found! MRoleDAO");}
		return null;
	}

	public List<MRole> showAll() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<MRole> list = session.createQuery(QUERYUS).getResultList();
			session.getTransaction().commit();
			return list;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();e.printStackTrace();
		} finally {session.close();}
		return null;
	}

	public Boolean update(MRole MRole) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(MRole);
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
			MRole MRole = session.load(MRole.class, id);session.delete(MRole);
			session.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {session.close();}
		return null;
	}
}