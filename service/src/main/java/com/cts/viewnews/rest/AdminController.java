package com.cts.viewnews.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.viewnews.bean.User;
import com.cts.viewnews.bean.UserArticle;
import com.cts.viewnews.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController extends ExceptionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/showuser")
	public List<User> showUsers(@RequestBody String userName) {
		LOGGER.info("Inside of showUsers() method of AdminController");
		System.out.println("userName in showUsers" + userName);
		return userService.showUsers(userName);
	}

	@PostMapping("/block")
	public boolean changeStatus(@RequestBody User user) {
		LOGGER.info("Inside of changeStatus() method of AdminController");
		boolean status = false;
		System.out.println("User in changeStatus" + user);
		status = userService.changeStatus(user);
		return status;
	}

}
