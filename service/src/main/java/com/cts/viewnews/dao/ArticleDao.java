package com.cts.viewnews.dao;



import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.viewnews.bean.Article;

@Component
public class ArticleDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(EntityManagerFactory emFactory) {
		this.sessionFactory = emFactory.unwrap(SessionFactory.class);
	}

	public void deleteFav(int articleId) {

		try {
			LOGGER.info("Start of deleteFav() method in ArticleDao");
			LOGGER.debug("{Id}", articleId);
			Session session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			Query q=  session.createQuery("delete FROM Article a where a.id=:articleId").setParameter("articleId", articleId);
			
			q.executeUpdate();
			session.close();
			LOGGER.info("End of save() method in userDao");
			
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		
		}
	}

	

}
