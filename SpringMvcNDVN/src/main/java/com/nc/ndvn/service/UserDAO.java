package com.nc.ndvn.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nc.model.User;
import com.nc.pbackup.Role;

/**
 * @author diennv
 * Guide:
 * 	 Save user:
 * 		+Check exists
 * 		+Fix empty
 * 		+Encode pass
 *	 Fix empty:
 *		+Fix + Remove unknow role
 *	 Update user:
 *		+Check not exsits
 *		+Update roles if roles is not null
 *		+Update pass if pass is not empty
 */
public class UserDAO {
	private static final String QUERYUS = "select u from User u";
	
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public void save(User user) {
        if (findByEmail(user.getEmail()) == null) {
        	System.out.println("Addd User!!! "+user.getEmail());
        	user.setRoles( FixEmptyId( (HashSet<Role>) user.getRoles()) );
            Session session = sessionFactory.openSession();
    		try {
    			PasswordEncoder pe = new BCryptPasswordEncoder();
    			user.setPassword(pe.encode(user.getPassword()));
    			session.beginTransaction();session.save(user);session.getTransaction().commit();
    		} catch (RuntimeException e) {
    			session.getTransaction().rollback();e.printStackTrace();
    		} finally {session.close();}
        } else {System.out.println("User exists!");}

	}
	public Boolean update(User user) {
		User user_found = findByEmail(user.getEmail());
		if ( user_found!=null ) {
			System.out.println("Update User!!! "+user.getEmail());
			if ( user.getRoles()!=null ) {user_found.setRoles( FixEmptyId( (HashSet<Role>) user.getRoles()) );}
			if ( !user.getPassword().isEmpty() ) {
    			PasswordEncoder pe = new BCryptPasswordEncoder();
    			user.setPassword(pe.encode(user.getPassword()));
    			user_found.setPassword(user.getPassword());
			}
			Session session = sessionFactory.openSession();
			try {
				session.beginTransaction();session.update(user_found);session.getTransaction().commit();return true;
			} catch (RuntimeException e) {
				session.getTransaction().rollback();e.printStackTrace();
			} finally {session.close();}
		} else {System.out.println("Not found user!");}
		return false;
	}
	private HashSet<Role> FixEmptyId(HashSet<Role> roles) {
    	RoleDAO rd=new RoleDAO();
    	HashSet<Role> newRoles = new HashSet<>();
    	for (Role r : roles) {
    		Role r_find=rd.findByName(r.getName());
    		if (r_find!=null) {newRoles.add(r_find);}
    		else {System.out.println("Not Found!");}
		}
    	for (Role r : newRoles) {System.out.println("++2+"+r.getName());}
    	return newRoles;
	}

	public User findById(int id) {
		Session session = sessionFactory.openSession();
		User user = session.find(User.class, id);
		System.out.println("MATCH user::"+user.getId()+"::"+user.getEmail());
		for (Role r : user.getRoles()) {r.setUsers(null);}
		session.close();
		return user;
	}
	public User findByEmail(String email) {
		try {
			Session session = sessionFactory.openSession();
			Query<User> query=session.createQuery(QUERYUS+" where u.email=:email");
			query.setParameter("email", email);
			User u = query.getSingleResult();
			for (Role r : u.getRoles()) {r.setUsers(null);}
			session.close();
			return u;
		} catch (NoResultException e) {
			System.out.println("Not Found! UserDAO");
		}
		return null;
	}

	public List<User> showAll() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<User> list = session.createQuery(QUERYUS).getResultList();
			for (User user : list) {
				for (Role r : user.getRoles()) {r.setUsers(null);}
			}
			session.getTransaction().commit();
			return list;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();e.printStackTrace();
		} finally {session.close();}
		return null;
	}

	public Boolean delete(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			User user = session.load(User.class, id);
			session.delete(user);
			session.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();System.out.println("Some Err!");
		} finally {session.close();}
		return false;
	}
}