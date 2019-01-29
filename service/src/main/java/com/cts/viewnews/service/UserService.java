package com.cts.viewnews.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.viewnews.bean.Language;
import com.cts.viewnews.bean.Role;
import com.cts.viewnews.bean.SignUpStatus;
import com.cts.viewnews.bean.User;
import com.cts.viewnews.dao.LanguageRepository;
import com.cts.viewnews.dao.RoleRepository;
import com.cts.viewnews.dao.UserDao;
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

			Role role = roleRepository.findById(user.getRole().getId());
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
	public List<User> findAllNewsAnalysts() {
		LOGGER.info("Inside of findAllNewsAnalysts() method of UserService");
		Role role = roleRepository.findById(2);
		return userRepository.findByRole(role);
	}

}
