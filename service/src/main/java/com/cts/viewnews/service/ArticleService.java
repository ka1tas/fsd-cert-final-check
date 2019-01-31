package com.cts.viewnews.service;


import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.viewnews.bean.Article;
import com.cts.viewnews.bean.ArticleStatus;
import com.cts.viewnews.bean.User;
import com.cts.viewnews.bean.UserArticle;
import com.cts.viewnews.dao.ArticleRepository;
import com.cts.viewnews.dao.UserRepository;

@Service
public class ArticleService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private UserRepository userRepository;


	@Transactional
	public List<Article> findFavArticle(int userId) {
		LOGGER.info("Inside of findAllRoles() method of RoleService");
		User user =  userRepository.findById(userId);
		return articleRepository.findByUser(user);
	}
	
	@Transactional
	public ArticleStatus save(UserArticle userArticle) {
		LOGGER.info("Inside of findAllRoles() method of RoleService");
	
		
		ArticleStatus status = new ArticleStatus();
		int id = userArticle.getUser().getId();
		User user = userRepository.findById(id);
		Article article = userArticle.getArticle();
		
		/*List<Article> articles = articleRepository.findByUser(user);
		for(Article art : articles){
			
		}
		*/
		
		article.setUser(user);
		System.out.println(article);
		articleRepository.save(article);
		status.setArticleExist(false);
		status.setSaveArticle(true);
		return status;				
	}


}
