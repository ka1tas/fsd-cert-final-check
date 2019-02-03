package com.cts.viewnews.mockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerMockMVC {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginControllerMockMVC.class);

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void testSuccessfullLogin() throws Exception {
		LOGGER.info("START");
		String USER_DATA = "{\"email\" : \"s@g.com\"" + "," + "\"password\" : \"12345\"" + "}";
		mockMvc.perform(post("/login/check").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authStatus").value("true"));

		LOGGER.info("END");
	}

	@Test
	public void testFailedLoginWithWrongEmail() throws Exception {
		LOGGER.info("START");
		String USER_DATA = "{\"email\" : \"s@gddddd.com\"" + "," + "\"password\" : \"12345\"" + "}";
		mockMvc.perform(post("/login/check").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authStatus").value("false"));

		LOGGER.info("END");
	}
	
	@Test
	public void testFailedLoginWithWrongPassword() throws Exception {
		LOGGER.info("START");
		String USER_DATA = "{\"email\" : \"s@g.com\"" + "," + "\"password\" : \"12ddd345\"" + "}";
		mockMvc.perform(post("/login/check").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authStatus").value("false"));

		LOGGER.info("END");
	}

	

}
