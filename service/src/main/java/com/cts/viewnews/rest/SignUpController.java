package com.cts.viewnews.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.viewnews.bean.Language;
import com.cts.viewnews.bean.Role;
import com.cts.viewnews.bean.SignUpStatus;
import com.cts.viewnews.bean.User;
import com.cts.viewnews.service.LanguageService;
import com.cts.viewnews.service.RoleService;
import com.cts.viewnews.service.UserService;

@RestController
@RequestMapping("/signup")
public class SignUpController extends ExceptionController{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LanguageService languageService;
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/add")
	public  SignUpStatus signup(@RequestBody User user){
		LOGGER.info("Inside of signup() method of SignUpController");
		System.out.println("User in ciokjhui"+ user);
		return userService.save(user);
	}

	
	@GetMapping("/analyst")
	public  List<User> getAnalysts( ){
		LOGGER.info("Inside of getAnalysts() method of SignUpController");
		return userService.findAllNewsAnalysts();
	}
	
	@GetMapping("/languages")
	public  List<Language> getLanguages( ){
		LOGGER.info("Inside of getLanguages() method of SignUpController");
		return languageService.findAllLanguages();
	}
	
	@GetMapping("/roles")
	public  List<Role> getRoles( ){
		LOGGER.info("Inside of getLanguages() method of SignUpController");
		return roleService.findAllRoles();
	}


}
