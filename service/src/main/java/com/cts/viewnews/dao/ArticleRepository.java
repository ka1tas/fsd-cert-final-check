package com.cts.viewnews.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.viewnews.bean.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	List<Article> findByUserId (int userId);
	
	Article findById(int id);
	
	/*//@Query(value= " delete FROM Article a where a.id=:articleId ", nativeQuery=true)
	Article deleteArticlesById(@Param("articleId") int articleId);*/
}
