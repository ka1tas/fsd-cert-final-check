package com.cts.viewnews.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.viewnews.bean.ArticleStatus;
import com.cts.viewnews.bean.UserArticle;
import com.cts.viewnews.service.ArticleService;

@RestController
@RequestMapping("/art")
public class ArticleController {

private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

@Autowired
private ArticleService articleService;


@PostMapping("/addfav")
public  ArticleStatus savefav(@RequestBody UserArticle article){
	LOGGER.info("Inside of savefav() method of ArticleController");
	System.out.println("Userarticle in savefav"+ article);
	return articleService.save(article);
}

}
