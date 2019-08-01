package com.nc.pbackup;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nc.model.MUser;
import com.nc.model.MUserLite;

public class MUserDAO {

	private static final String QUERYUS = "select muser.userId,muser.createdBy,muser.createdDate,muser.updatedBy,muser.updatedDate,muser.fullName,muser.userName from MUser as muser";
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public void save(MUser user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {session.close();}
	}

	public MUser findById(int id) {
		Session session = sessionFactory.openSession();
		MUser con = session.find(MUser.class, id);
		session.close();
		return con;
	}
	public Object[] findByUserName(String name) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Query<Object[]> query=session.createQuery(QUERYUS+" where muser.userName=:uname");
			query.setParameter("uname", name);
			Object[] list = query.getSingleResult();
			session.getTransaction().commit();
			return list;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();e.printStackTrace();
		} finally {session.close();}
		return null;
	}
	public MUserLite findLite(String name) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Query<MUserLite> query=session.createQuery(
				"select new "+MUserLite.class.getName()+" (muser.userId,muser.createdBy,muser.createdDate,muser.updatedBy,muser.updatedDate,muser.fullName,muser.userName)"
				+" from "+MUser.class.getName()+" as muser"
				+" where muser.userName=:uname");
			query.setParameter("uname", name);
			MUserLite list = query.getSingleResult();
			session.getTransaction().commit();
			return list;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();e.printStackTrace();
		} finally {session.close();}
		return null;
	}

	public List<MUser> showAll() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<MUser> list = session.createQuery(QUERYUS).getResultList();
			session.getTransaction().commit();
			return list;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();e.printStackTrace();
		} finally {session.close();}
		return null;
	}

	public Boolean update(MUser user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(user);
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
			MUser user = session.load(MUser.class, id);
			session.delete(user);
			session.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {session.close();}
		return null;
	}
}