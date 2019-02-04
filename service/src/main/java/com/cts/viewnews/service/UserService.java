package com.cts.viewnews.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.viewnews.bean.AuthenticationStatus;
import com.cts.viewnews.bean.Language;
import com.cts.viewnews.bean.Role;
import com.cts.viewnews.bean.SignUpStatus;
import com.cts.viewnews.bean.User;
import com.cts.viewnews.dao.LanguageRepository;
import com.cts.viewnews.dao.RoleRepository;
import com.cts.viewnews.dao.UserRepository;

@Service
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Transactional
	public SignUpStatus save(User user) {
		LOGGER.info("START : Inside save() method of UserService");
		LOGGER.debug("User Object :  {}", user);
		SignUpStatus status = new SignUpStatus();
		status.setSignupStatus(false);
		status.setEmailExist(true);
		User existingUser = userRepository.findByEmail(user.getEmail());
		LOGGER.debug("existingUser Object :  {}", existingUser);
		if (existingUser == null) {

			Role role = roleRepository.findById(2);
			Language lang = languageRepository.findById(user.getLanguage().getId());
			user.setRole(role);
			user.setLanguage(lang);
			userRepository.save(user);
			status.setSignupStatus(true);
			status.setEmailExist(false);
		}
		LOGGER.debug("status Object :  {}", status);
		LOGGER.info("END of save() method of UserService");
		return status;
	}



	@Transactional
	public List<User> showUsers(String name) {
		LOGGER.info("Inside of showUsers() method of UserService");
		return userRepository.findByName(name);
	}
	

	@Transactional
	public boolean changeStatus(User user) {
		LOGGER.info("Inside of showUsers() method of UserService");
		boolean status = false;
		User actualUser = userRepository.findById(user.getId());
		String blocked = actualUser.getBlocked();

		if (blocked.equals("no")) {
			actualUser.setBlocked("yes");
		} else if (blocked.equals("yes")) {
			actualUser.setBlocked("no");
		}

		userRepository.save(actualUser);

		status = true;

		return status;

	}

	@Transactional
	public AuthenticationStatus login(User user) {
		LOGGER.info("Inside of login() method of UserService");
		AuthenticationStatus status = new AuthenticationStatus();
		LOGGER.debug("user Object :  {}", user);
		String email = user.getEmail();
		String password = user.getPassword();
		User actualUser = userRepository.findByEmail(email);
		LOGGER.debug("ActualUser Object :  {}", actualUser);
		if (actualUser == null) {
			status.setAuthStatus(false);
			status.setUser(null);
		} else {
			String actualPassword = actualUser.getPassword();
			String blocked = actualUser.getBlocked();
			if (actualPassword.equals(password) && blocked.equals("no")) {

				status.setAuthStatus(true);
				status.setUser(actualUser);
				status.setIsblocked(false);
			}

			if (actualPassword.equals(password) && blocked.equals("yes")) {
				status.setAuthStatus(true);
				status.setUser(actualUser);
				status.setIsblocked(true);
			}
		}
		LOGGER.debug("status Object :  {}", status);
		return status;

	}

}
