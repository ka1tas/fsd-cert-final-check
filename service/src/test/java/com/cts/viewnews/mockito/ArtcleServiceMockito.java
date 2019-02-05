package com.cts.viewnews.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.viewnews.bean.Article;
import com.cts.viewnews.bean.ArticleStatus;
import com.cts.viewnews.bean.UserArticle;
import com.cts.viewnews.dao.ArticleRepository;
import com.cts.viewnews.dao.LanguageRepository;
import com.cts.viewnews.dao.RoleRepository;
import com.cts.viewnews.dao.UserRepository;
import com.cts.viewnews.service.ArticleService;

public class ArtcleServiceMockito {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArtcleServiceMockito.class);

	@Mock
	private UserRepository userRepository;

	@Mock
	private LanguageRepository languageRepository;

	@Mock
	private RoleRepository roleRepository;
	
	@Mock
	private ArticleRepository articleRepository;


	@InjectMocks
	private ArticleService service;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void testSuccesfullLogin() {
		LOGGER.info("START of testSuccesfullLogin() testing in UserSeviceMockito");
		
		int id = 1;
		Article testArticle = new Article();
		testArticle.setUserId(id);
		testArticle.setContent("Hello sa sasa");
		
		Article testArticle2 = new Article();
		testArticle.setUserId(2);
		testArticle.setContent("Not Hello sa sasssa");
		
		
		List<Article> testArticles = new ArrayList<Article>();
		testArticles.add(testArticle2);
		testArticles.add(testArticle);
		
		UserArticle testUserArticle = new UserArticle(testArticle,id);

	
		
		when(articleRepository.findByUserId(testUserArticle.getUserId())).thenReturn(testArticles);
		when(articleRepository.save(testArticle)).thenReturn(testArticle);

		
		ArticleStatus expectedstatus = new ArticleStatus();
		expectedstatus.setSaveArticle(true);
		expectedstatus.setArticleExist(false);
		LOGGER.debug("status Should be test: " + expectedstatus);
		ArticleStatus status = service.save(testUserArticle);
		LOGGER.debug("status from test: " + status);
		verify(articleRepository, times(1)).save(testArticle);
		assertEquals(true, expectedstatus.equals(status));
		LOGGER.info("END of testSuccesfullLogin() testing in UserSeviceMockito");
	}

}
