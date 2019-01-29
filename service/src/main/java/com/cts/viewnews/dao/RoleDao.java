package com.cts.viewnews.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.viewnews.bean.Language;
import com.cts.viewnews.bean.Role;

@Component
public class RoleDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(EntityManagerFactory emFactory) {
		this.sessionFactory = emFactory.unwrap(SessionFactory.class);
	}

	public List<Role> findAll() {

		LOGGER.info("Start of findall role");
		try {
			Session session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			List<Role> roles = (List<Role>) session.createQuery("from Role").list();
			session.close();
			return roles;
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("error");
		}
		LOGGER.info("End of findall role");
		return null;
	}

	public Role findById(int Id) {

		try {
			Session session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			Role role =  (Role) session.createQuery("from Role R where R.id = :id").setParameter("id",Id);
			session.close();
			return role;
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("error");
		}
		return null;
	}

}
