package com.cts.viewnews.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.viewnews.bean.Article;
import com.cts.viewnews.bean.AuthenticationStatus;
import com.cts.viewnews.bean.User;
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
		User testUser = new User();
		testUser.setEmail("s@g.com");
		testUser.setPassword("12345");
		testUser.setBlocked("no");
		
		List<Article> articles; 
		
		when(articleRepository.findByUserId(testUser.getId())).thenReturn(testUser);

		AuthenticationStatus expectedstatus = new AuthenticationStatus();
		expectedstatus.setAuthStatus(true);
		expectedstatus.setUser(testUser);
		LOGGER.debug("status Should be test: " + expectedstatus);
		boolean status = service.login(testUser);
		LOGGER.debug("status from test: " + status);
		verify(userRepository, times(1)).findByEmail(testUser.getEmail());
		assertEquals(true, expectedstatus.equals(status));
		LOGGER.info("END of testSuccesfullLogin() testing in UserSeviceMockito");
	}

}
