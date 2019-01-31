package com.cts.viewnews.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.viewnews.bean.Article;
import com.cts.viewnews.bean.User;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	List<Article> findByUser (User user);
}
