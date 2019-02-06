package com.cts.viewnews.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.viewnews.bean.AuthenticationStatus;
import com.cts.viewnews.bean.User;
import com.cts.viewnews.jwt.security.JwtGenerator;
import com.cts.viewnews.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController extends ExceptionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtGenerator jwtGenerator;

	@PostMapping("/check")
	public AuthenticationStatus signup(@RequestBody User user) {
		LOGGER.info("Inside of signup() method of SignUpController");
		System.out.println("User in Login" + user);
		
		AuthenticationStatus status =  userService.login(user);

		if (status.isAuthStatus()) {
			status.setToken(jwtGenerator.generate(status.getUser()));
			LOGGER.debug("Token : {}", status.getToken());
		}
		return status;
	}

}
