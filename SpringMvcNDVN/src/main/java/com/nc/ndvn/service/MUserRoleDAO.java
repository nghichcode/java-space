package com.nc.ndvn.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nc.model.MUserRoles;

public class MUserRoleDAO {
	private static final String QUERYUS = "select r from MUserRoles r";
	
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public MUserRoles findById(long id) {
		Session session = sessionFactory.openSession();
		MUserRoles con = session.find(MUserRoles.class, id);
		System.out.println(con.toString());
		session.close();
		return con;
	}
	public MUserRoles findByName(String name) {
		try {
			Session session = sessionFactory.openSession();
			Query<MUserRoles> query=session.createQuery(QUERYUS+" where r.name=:name");
			query.setParameter("name", name);
			MUserRoles u = query.getSingleResult();
			session.close();
			return u;			
		} catch (NoResultException e) {System.out.println("Not Found! MUserRolesDAO");}
		return null;
	}

}