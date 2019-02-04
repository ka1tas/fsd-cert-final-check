package com.cts.viewnews.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.viewnews.bean.AuthenticationStatus;
import com.cts.viewnews.bean.Language;
import com.cts.viewnews.bean.Role;
import com.cts.viewnews.bean.SignUpStatus;
import com.cts.viewnews.bean.User;
import com.cts.viewnews.dao.LanguageRepository;
import com.cts.viewnews.dao.RoleRepository;
import com.cts.viewnews.dao.UserRepository;
import com.cts.viewnews.service.UserService;

public class UserSeviceMockito {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserSeviceMockito.class);

	@Mock
	private UserRepository userRepository;

	@Mock
	private LanguageRepository languageRepository;

	@Mock
	private RoleRepository roleRepository;

	@InjectMocks
	private UserService service;

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

		when(userRepository.findByEmail(testUser.getEmail())).thenReturn(testUser);

		AuthenticationStatus expectedstatus = new AuthenticationStatus();
		expectedstatus.setAuthStatus(true);
		expectedstatus.setUser(testUser);
		LOGGER.debug("status Should be test: " + expectedstatus);
		AuthenticationStatus status = service.login(testUser);
		LOGGER.debug("status from test: " + status);
		verify(userRepository, times(1)).findByEmail(testUser.getEmail());
		assertEquals(true, expectedstatus.equals(status));
		LOGGER.info("END of testSuccesfullLogin() testing in UserSeviceMockito");
	}

	@Test
	public void testFailedLogin() {
		LOGGER.info("START of testFailedLogin() testing in UserSeviceMockito");
		User testUser = new User();
		testUser.setEmail("saikat@gmail.com");
		testUser.setPassword("12345");

		when(userRepository.findByEmail(testUser.getEmail())).thenReturn(null);

		AuthenticationStatus expectedstatus = new AuthenticationStatus();
		expectedstatus.setAuthStatus(false);
		// expectedstatus.setUser(testUser);
		LOGGER.debug("status Should be test: " + expectedstatus);
		AuthenticationStatus status = service.login(testUser);
		LOGGER.debug("status from test: " + status);
		verify(userRepository, times(1)).findByEmail(testUser.getEmail());
		assertEquals(true, expectedstatus.equals(status));
		LOGGER.info("END of testFailedLogin() testing in UserSeviceMockito");
	}

	@Test
	public void testSuccesfullSignup() {
		LOGGER.info("START of testSuccesfullSignup() testing in UserSeviceMockito");

		Role testRole = new Role(1, "Admin");
		Language testLanguage = new Language(1, "en");
		User testUser = new User(0, "Saikat", "saikat@gmail.com", "123456", "no", testRole, testLanguage);

		when(userRepository.findByEmail(testUser.getEmail())).thenReturn(null);
		when(roleRepository.findById(testUser.getRole().getId())).thenReturn(testRole);
		when(languageRepository.findById(testUser.getLanguage().getId())).thenReturn(testLanguage);
		when(userRepository.save(testUser)).thenReturn(testUser);

		SignUpStatus expectedstatus = new SignUpStatus();
		expectedstatus.setEmailExist(false);
		expectedstatus.setSignupStatus(true);

		LOGGER.debug("status Should be test: " + expectedstatus);
		SignUpStatus status = service.save(testUser);
		LOGGER.debug("status from test: " + status);
		verify(userRepository, times(1)).save(testUser);
		assertEquals(true, expectedstatus.equals(status));
		LOGGER.info("END of testSuccesfullSignup() testing in UserSeviceMockito");
	}

	@Test
	public void testExistingEmailWhileSignup() {
		LOGGER.info("START of testExistingEmailWhileSignup() testing in UserSeviceMockito");

		Role testRole = new Role(1, "Admin");
		Language testLanguage = new Language(1, "en");
		User testUser = new User(0, "Saikat", "saikat@gmail.com", "123456", "no", testRole, testLanguage);

		when(userRepository.findByEmail(testUser.getEmail())).thenReturn(testUser);
		when(roleRepository.findById(testUser.getRole().getId())).thenReturn(testRole);
		when(languageRepository.findById(testUser.getLanguage().getId())).thenReturn(testLanguage);
		when(userRepository.save(testUser)).thenReturn(testUser);

		SignUpStatus expectedstatus = new SignUpStatus();
		expectedstatus.setEmailExist(true);
		expectedstatus.setSignupStatus(false);

		LOGGER.debug("status Should be test: " + expectedstatus);
		SignUpStatus status = service.save(testUser);
		LOGGER.debug("status from test: " + status);
		verify(userRepository, times(0)).save(testUser);
		assertEquals(true, expectedstatus.equals(status));
		LOGGER.info("END of testExistingEmailWhileSignup() testing in UserSeviceMockito");
	}
	
	
	@Test
	public void testChangeStatus() {
		LOGGER.info("START of testChangeStatus() testing in UserSeviceMockito");
		User testUser = new User();
		testUser.setId(1);
		testUser.setEmail("saikat@gmail.com");
		testUser.setPassword("12345");
		testUser.setBlocked("no");
		
		
		when(userRepository.findById(testUser.getId())).thenReturn(testUser);
		when(userRepository.save(testUser)).thenReturn(testUser);

		boolean expectedstatus = true;
		
		LOGGER.debug("status Should be test: " + expectedstatus);
		boolean status = service.changeStatus(testUser);
		LOGGER.debug("status from test: " + status);
		verify(userRepository, times(1)).findById(testUser.getId());
		assertEquals(expectedstatus, status);
		LOGGER.info("END of testSuccesfullLogin() testing in UserSeviceMockito");
	}

}
