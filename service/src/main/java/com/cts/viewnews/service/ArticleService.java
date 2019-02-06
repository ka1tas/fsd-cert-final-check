package com.cts.viewnews.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.viewnews.bean.Article;
import com.cts.viewnews.bean.ArticleStatus;
import com.cts.viewnews.bean.UserArticle;
import com.cts.viewnews.dao.ArticleRepository;

@Service
public class ArticleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private ArticleRepository articleRepository;

	@Transactional
	public List<Article> findFavArticle(int userId) {
		LOGGER.info("Inside of findFavArticle() method of ArticleService");
		return articleRepository.findByUserId(userId);
	}

	@Transactional
	public void deleteArticle(int artId) {
		LOGGER.info("Inside of deleteArticle() method of ArticleService");
		Article article = articleRepository.findById(artId);
		articleRepository.delete(article);
	}

	@Transactional
	public ArticleStatus save(UserArticle userArticle) {
		LOGGER.info("Inside of save() method of ArticleService");

		ArticleStatus status = new ArticleStatus();
		int id = userArticle.getUserId();
		Article article = userArticle.getArticle();
		int counter = 0;

		List<Article> articles = articleRepository.findByUserId(id);
		for (Article art : articles) {
			if (art.getContent().equals(article.getContent())) {
				counter++;
			}
		}

		if (counter == 0) {
			article.setUserId(id);
			System.out.println(article);
			articleRepository.save(article);
			status.setArticleExist(false);
			status.setSaveArticle(true);

		} else {

			status.setArticleExist(true);
			status.setSaveArticle(false);
		}
		return status;

	}

}
