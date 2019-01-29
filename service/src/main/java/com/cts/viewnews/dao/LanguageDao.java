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
import com.cts.viewnews.bean.User;

@Component
public class LanguageDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(EntityManagerFactory emFactory) {
		this.sessionFactory = emFactory.unwrap(SessionFactory.class);
	}

	public List<Language> findAll() {
		LOGGER.info("Start of findall languages");
		try {
			Session session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			List<Language> languages = (List<Language>) session.createQuery("from Language").list();
			session.close();
			return languages;
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("error");
		}
		LOGGER.info("End  of findall languages");
		return null;
	}

	public Language findById(int Id) {
		
		try {
			Session session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			Language language = (Language) session.createQuery("from Language L where L.id = :id")
					.setParameter("id", Id);
			session.close();
			return language;
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("error");
		}
		return null;
	}

}
